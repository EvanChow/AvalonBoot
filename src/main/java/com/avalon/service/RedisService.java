package com.avalon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avalon.dao.MyRedisDao;

@Service
public class RedisService {

	@Autowired
	private MyRedisDao myRedisDao;
	
	public boolean addString(String key,String value){
		return myRedisDao.set(key.getBytes(),value.getBytes());
	}
	
	public String getString(String key){
		return myRedisDao.get(key.getBytes());
	}
	
	
	
}
