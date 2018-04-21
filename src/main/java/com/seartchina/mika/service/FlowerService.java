package com.seartchina.mika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seartchina.mika.dao.flower.FlowerDao;
import com.seartchina.mika.dao.flower.FlowerGiftDao;
import com.seartchina.mika.service.exception.ElementException;
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
		
	}
	
	public void plantFlower(Integer flowerId) {
		
	}
	
	public void feedFlower(Integer userId, Integer flowerId, Integer elementId, Integer quantity) throws ElementException{
		
	}
	
	public void genGift(Integer flowerId) {
		
	}

}
