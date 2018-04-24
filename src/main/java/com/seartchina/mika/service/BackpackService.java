package com.seartchina.mika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seartchina.mika.dao.flower.FlowerGiftDao;
import com.seartchina.mika.dao.flower.pojo.FlowerGift;
import com.seartchina.mika.service.exception.ElementException;
import com.seartchina.mika.service.exception.UnauthorizedException;
import com.seartchina.mika.service.util.ElementManager;

@Service
public class BackpackService {
	
	@Autowired
	public FlowerGiftDao flowerGiftDao;
	
	@Autowired
	public ElementManager elementManager;
	
	public void transferGift(Integer giftId, Integer srcUserId, Integer tgtUserId) {
		FlowerGift flowerGift = flowerGiftDao.selectFlowerGiftById(giftId);
		if(!flowerGift.getUserId().equals(srcUserId)) {
			throw new UnauthorizedException();
		}
		flowerGiftDao.updateFlowerGiftOwner(giftId, tgtUserId);
	}
	
	public void transferElement(Integer srcUserId, Integer tgtUserId, Integer elementId, Integer quantity) throws ElementException {
		elementManager.useElement(srcUserId, elementId, quantity);
		elementManager.addElement(tgtUserId, elementId, quantity);
	}
	

}
