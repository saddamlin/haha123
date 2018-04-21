package com.seartchina.mika.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seartchina.mika.dao.flower.FlowerElementDao;
import com.seartchina.mika.dao.user.UserElementDao;
import com.seartchina.mika.dao.user.pojo.UserElement;
import com.seartchina.mika.service.exception.ElementException;

@Service
public class ElementManager {
	
	@Autowired
	private UserElementDao userElementDao;
	
	@Autowired
	private FlowerElementDao flowerElementDao;
	
	// TODO: replace with real logic to generate reward
	public ElementReward genElementReward() {
		return new ElementReward(0,0);
	}
	
	public void addElement(Integer userId, Integer elementId, Integer quantity) {
		UserElement userElement = userElementDao.selectUserElement(userId, elementId);
		if(userElement == null) {
			userElement = new UserElement();
			userElement.setUserId(userId);
			userElement.setElementId(elementId);
			userElement.setQuantity(quantity);
			userElementDao.insertUserElement(userElement);
		}else {
			Integer newQuantity = userElement.getQuantity() + quantity;
			userElement.setQuantity(newQuantity);
			userElementDao.updateUserElement(userElement);
		}
	}
	
	public void useElement(Integer userId, Integer elementId, Integer quantity) throws ElementException {
		UserElement userElement = userElementDao.selectUserElement(userId, elementId);
		if(userElement == null) {
			throw new ElementException("Not enough element!");
		} else {
			Integer currentQuantity = userElement.getQuantity();
			if(currentQuantity < quantity) {
				throw new ElementException("Not enough element!");
			}else {
				Integer newQuantity = userElement.getQuantity() - quantity;
				userElement.setQuantity(newQuantity);
				userElementDao.updateUserElement(userElement);
			}
		}
	}
	
	
	public class ElementReward{
		public Integer elementId;
		public Integer quantity;
		
		public ElementReward(Integer elementId, Integer quantity) {
			this.elementId = elementId;
			this.quantity = quantity;
		}
	}

}
