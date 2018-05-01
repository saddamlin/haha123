package com.seartchina.mika.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seartchina.mika.controller.entity.RespObject;

@Controller
@RequestMapping("/flower")
public class FlowerController extends AbstractMikaController{
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET})
	@ResponseBody
	public RespObject getFlower(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") Integer id) {
		
		
		return new RespObject(true);
	}

}
