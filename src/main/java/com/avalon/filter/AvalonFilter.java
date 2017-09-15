package com.avalon.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.stereotype.Component;

/**
 * 
 * @类名: AvalonFilter
 * @功能描述:过滤器
 * @类创建人: Evan
 * @类创建时间： 2016-8-17 上午10:26:02
 */
@Component("avalonFilter") 
public class AvalonFilter implements Filter{

    public void destroy() {
        //System.out.println("Filter destroy.............");
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
       // System.out.println("doFilter.............");
        arg2.doFilter(arg0, arg1);
    }

    public void init(FilterConfig arg0) throws ServletException {
       // System.out.println("Filter init.............");
    }

}
