package com.avalon.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * 
 * @类名: AvalonServlet
 * @功能描述:Servlet
 * @类创建人: Evan
 * @类创建时间： 2016-8-17 上午10:26:32
 */
@Component("avalonServlet")  
public class AvalonServlet implements Servlet{

    public void destroy() {
        System.out.println("Servlet destroy.............");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public String getServletInfo() {
        return null;
    }

    public void init(ServletConfig arg0) throws ServletException {
        System.out.println("Servlet init.............");
        
    }

    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        System.out.println("Servlet service.............");
        
    }

}
