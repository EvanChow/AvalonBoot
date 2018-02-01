package com.avalon.service.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.avalon.service.websocket.messagebroker.MessageBrokerService;
import com.avalon.service.websocket.session.WebSocketSessionService;

/**
 * 
 * @类名: MyJob
 * @功能描述:定时任务
 * @类创建人: Evan
 * @类创建时间： 2017-11-13 下午04:31:59
 */
@Component
public class MyJob {
    
    public final static long SECOND = 1 * 1000;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    @Autowired
    private WebSocketSessionService sessionService;
    @Autowired
    private MessageBrokerService messagebrokerService;
    
    
    @Scheduled(cron = "0/30 * * * * ?")
    public void cronJob() {
      
      //System.out.println("Execute==========================================="+sdf.format(new Date()));
      sessionService.sendAllMessage("系统时间戳："+sdf.format(new Date()));
      messagebrokerService.SendAll("/topic/all", "系统时间戳："+sdf.format(new Date()));
    }
    
}
