package com.seartchina.mika.controller.entity;

public class RespObject {
	
	protected Boolean isSuccess;
	protected String message;
	protected Object data;
	
	public RespObject(Boolean isSuccess) {
		this.isSuccess = isSuccess;
		this.message = message;
	}
	
	public RespObject(Boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message;
	}
	
	public RespObject(Boolean isSuccess, String message, Object data) {
		this.isSuccess = isSuccess;
		this.message = message;
		this.data = data;
	}
	
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
