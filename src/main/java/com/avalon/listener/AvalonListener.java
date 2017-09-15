package com.avalon.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

/**
 * 
 * @类名: AvalonListener
 * @功能描述:监听器
 * @类创建人: Evan
 * @类创建时间： 2016-8-17 上午10:26:16
 */
@Component("avalonListener") 
public class AvalonListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("contextDestroyed...");  

    }

    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("listener contextInitialized...");

    }

}
