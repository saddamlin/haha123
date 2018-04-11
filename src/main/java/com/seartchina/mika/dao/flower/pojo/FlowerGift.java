package com.seartchina.mika.dao.flower.pojo;

import java.util.Date;

public class FlowerGift {
	
	private Integer giftId;
	private Integer flowerId;
	private Integer userId;
	private Integer giftType;
	private String giftDetails;
	private Integer giftStatus;
	private Date createdDate;
	private Date lastUpdateDate;
	public Integer getGiftId() {
		return giftId;
	}
	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}
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
	public Integer getGiftType() {
		return giftType;
	}
	public void setGiftType(Integer giftType) {
		this.giftType = giftType;
	}
	public String getGiftDetails() {
		return giftDetails;
	}
	public void setGiftDetails(String giftDetails) {
		this.giftDetails = giftDetails;
	}
	public Integer getGiftStatus() {
		return giftStatus;
	}
	public void setGiftStatus(Integer giftStatus) {
		this.giftStatus = giftStatus;
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
