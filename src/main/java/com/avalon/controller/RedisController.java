package com.avalon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avalon.service.RedisService;
import com.avalon.vo.Json;




@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/add")
    @ResponseBody
	public Json add(String key,String value){
		return new Json(redisService.addString(key, value),"ok","成功");
	}
	
	@RequestMapping("/get")
    @ResponseBody
	public Json get(String key){
		return new Json(true,"ok",redisService.getString(key));
	}
	
	
}
