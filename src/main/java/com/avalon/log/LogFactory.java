package com.avalon.log;

import org.apache.log4j.Logger;

/**
 * 
 * @类名: LogFactory
 * @功能描述:日志工厂
 * @类创建人: Mr
 * @类创建时间： 2015-8-19 下午02:14:26
 */
public class LogFactory {
	
	private static LogFactory instance = new LogFactory();

	private LogFactory() {
		
	}

	public static LogFactory getInstance() {
		return instance;
	}

	public Logger getLog(String channel) {
		return Logger.getLogger(channel);
	}
}
