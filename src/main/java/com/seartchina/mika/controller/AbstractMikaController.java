package com.seartchina.mika.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.seartchina.mika.controller.entity.RespObject;

public abstract class AbstractMikaController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(Exception.class)
	public RespObject handleException(HttpServletRequest request, Exception e){
		log.error(e.getMessage());
		return new RespObject(false, e.getMessage());
	}
	
	

}
