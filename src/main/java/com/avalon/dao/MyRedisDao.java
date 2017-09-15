package com.avalon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyRedisDao {
    
    @Autowired
    private StringRedisTemplate template;
    
    public void add(){
         
    }
    
    
}
