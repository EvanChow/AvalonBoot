package com.avalon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.avalon.service.quartz.ScheduleJobService;

/**
 * 
 * @类名: QuartzApplicationRunner
 * @功能描述:这里通过设定value的值来指定执行顺序
 * @类创建人: Evan
 * @类创建时间： 2018-1-24 下午05:05:45
 */
@Component
@Order(value = 1)
public class QuartzApplicationRunner implements ApplicationRunner {
    
    
    @Autowired
    private ScheduleJobService scheduleJobService;
    
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("初始化job任务。。。。。。。。。。。。。。。。。");
       // scheduleJobService.init();//初始化
        
    }

}
