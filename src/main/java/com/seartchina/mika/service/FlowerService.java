package com.seartchina.mika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seartchina.mika.dao.flower.FlowerDao;
import com.seartchina.mika.dao.flower.FlowerGiftDao;
import com.seartchina.mika.dao.flower.pojo.Flower;
import com.seartchina.mika.service.constants.FlowerStatus;
import com.seartchina.mika.service.exception.ElementException;
import com.seartchina.mika.service.exception.UnauthorizedException;
import com.seartchina.mika.service.util.ElementManager;

@Service
public class FlowerService {
	
	@Autowired
	private FlowerDao flowerDao;
	
	@Autowired
	private FlowerGiftDao flowerGiftDao;
	
	@Autowired
	private ElementManager elementManager;
	
	
	public void initFlower(Integer userId) {
		Flower flower = new Flower();
		flower.setUserId(userId);
		flower.setFlowerExp(0);
		flower.setFlowerLevel(0);
		flower.setFlowerStatus(FlowerStatus.SEED_UNPLANTED);
		flowerDao.insertFlower(flower);
	}
	
	public void plantFlower(Integer flowerId, Integer userId) {
		Flower flower = flowerDao.selectFlowerById(flowerId);
		if(!flower.getUserId().equals(userId)) {
			throw new UnauthorizedException();
		}
		
		flower.setFlowerStatus(FlowerStatus.SEED_PLANTED);
		flowerDao.updateFlower(flower);
	}
	
	public void feedFlower(Integer userId, Integer flowerId, Integer elementId, Integer quantity) throws ElementException{
		Flower flower = flowerDao.selectFlowerById(flowerId);
		if(!flower.getUserId().equals(userId)) {
			throw new UnauthorizedException();
		}
		elementManager.addFlowerElement(flowerId, elementId, quantity);
	}
	
	public void removeFlower(Integer flowerId, Integer userId) {
		Flower flower = flowerDao.selectFlowerById(flowerId);
		if(!flower.getUserId().equals(userId)) {
			throw new UnauthorizedException();
		}
		flower.setFlowerStatus(FlowerStatus.REMOVED);
		flowerDao.updateFlower(flower);
	}
	
	public void genGift(Integer flowerId, Integer userId) {
		
	}
	

}
