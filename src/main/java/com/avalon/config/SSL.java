package com.avalon.config;

import org.springframework.boot.context.embedded.Ssl;
import org.springframework.boot.context.embedded.SslStoreProvider;

/**
 * 
 * @类名: SSL
 * @功能描述:证书
 * @类创建人: Evan
 * @类创建时间： 2016-8-17 上午10:44:28
 */
public class SSL {
        
    public static Ssl AvalonSsl(){
        
        Ssl ssl=new Ssl();
        
        return ssl;
    }
    
    public static SslStoreProvider AvalonSslStoreProvider(){
        return null;
    }
    
    
    
    
}
