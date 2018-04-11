package com.seartchina.mika.dao.flower.pojo;

import java.util.Date;

public class Flower {
	
	private Integer flowerId;
	private Integer userId;
	private Integer flowerStatus;
	private Integer flowerLevel;
	private Integer flowerExp;
	private Date createdDate;
	private Date lastUpdateDate;
	public Integer getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getFlowerStatus() {
		return flowerStatus;
	}
	public void setFlowerStatus(Integer flowerStatus) {
		this.flowerStatus = flowerStatus;
	}
	public Integer getFlowerLevel() {
		return flowerLevel;
	}
	public void setFlowerLevel(Integer flowerLevel) {
		this.flowerLevel = flowerLevel;
	}
	public Integer getFlowerExp() {
		return flowerExp;
	}
	public void setFlowerExp(Integer flowerExp) {
		this.flowerExp = flowerExp;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	

}
