package com.avalon.config;

import java.io.File;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

/**
 * 
 * @类名: WebConfig
 * @功能描述:web容器配置类
 * @类创建人: Evan
 * @类创建时间： 2016-8-17 上午10:23:03
 */
@Component
public class WebConfig implements EmbeddedServletContainerCustomizer  {

    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setContextPath("/AvalonBoot");//修改根目录路径  
        container.setPort(8081);//启动的端口号
        container.setSessionTimeout(30);//超时设置
        container.setDocumentRoot(new File(""));
        
        //SSL 配置
//        container.setSsl(SSL.AvalonSsl());
//        container.setSslStoreProvider(SSL.AvalonSslStoreProvider());
    }

}
