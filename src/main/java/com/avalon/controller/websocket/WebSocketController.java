package com.avalon.controller.websocket;

import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.avalon.vo.Result;



@Controller
public class WebSocketController {  
    
    /**
     * 
     * @方法名: addNum
     * @功能描述: 消息订阅
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： 2016-5-25 下午05:32:40
     */
    
    @MessageMapping("/add")
    @SendTo("/topic/showResult")    
    public Result addNum(Map<String,String> input) throws Exception {
        Result result = new Result("");  
        return result;
    }
    
   
    
    
    
}
