package com.gy612.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gy612.loan.entity.CoopBusiness;
import com.gy612.loan.entity.CoopBusinessExample;
import com.gy612.loan.service.CoopBusinessService;

@Controller
@RequestMapping("/coopBusiness")
public class CoopBusinessController {
	
	@Autowired
	private CoopBusinessService coopBusinessService;
	
	@RequestMapping(value="/getAllCoopBusiness",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public List<CoopBusiness> getAllCoopBusiness(){
		
		CoopBusinessExample example = new CoopBusinessExample();
		List<CoopBusiness> list = coopBusinessService.selectByExample(example);
		
		return list;
	}

}
