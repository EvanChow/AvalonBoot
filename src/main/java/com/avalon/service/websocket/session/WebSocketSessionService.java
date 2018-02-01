package com.avalon.service.websocket.session;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.avalon.log.ILog;

/**
 * 
 * @类名: WebSocketSessionService
 * @功能描述:无状态WebSocketSession，只要连上就能获取消息
 * @类创建人: Evan
 * @类创建时间： 2016-4-19 上午11:12:16
 */
@Service
public class WebSocketSessionService implements ILog{
    
    private CopyOnWriteArrayList<WebSocketSession>  websocketsessions=new CopyOnWriteArrayList<WebSocketSession>();
    

    /**
     * 
     * @方法名: onLine
     * @功能描述: 上线
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： 2016-4-18 下午05:05:06
     */
    public void onLine(WebSocketSession session){
        loggerNormal.info("ID="+session.getId()+"上线");
        websocketsessions.add(session);
    }
    /**
     * 
     * @方法名: offLine
     * @功能描述: 下线
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： 2016-4-18 下午05:05:17
     */
    public void offLine(WebSocketSession session){
        loggerNormal.info("ID="+session.getId()+"下线");
        websocketsessions.remove(session);
    }
    
    /**
     * 
     * @方法名: sendMessage
     * @功能描述: 发送给某一个人
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： 2016-4-18 下午05:05:25
     */
    public void sendMessage(WebSocketSession session,String msg){
        TextMessage textMessage = new TextMessage(msg);
        try {
            session.sendMessage(textMessage);
            loggerNormal.info("发送给ID="+session.getId()+"消息");
        } catch (IOException e) {
            loggerError.info("发送给ID="+session.getId()+"消息失败");
        }
    }
    /**
     * 
     * @方法名: sendAllMessage
     * @功能描述: 发送给所有在线人员
     * @参数：@param
     * @返回：@return
     * @创建人: Evan
     * @创建时间： 2016-4-18 下午05:05:38
     */
    public void sendAllMessage(String msg){
        for(WebSocketSession session:websocketsessions){
            sendMessage(session,msg);
        }
    }
    
    
    
    
    
    
    
}
