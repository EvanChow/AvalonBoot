/**
 * 
 */
package com.avalon.log;

import org.apache.log4j.Logger;

/**
 * 
 * @类名: ILog
 * @功能描述:接口定义
 * @类创建人: Mr
 * @类创建时间： 2015-8-19 下午02:14:18
 */
public interface ILog {

	/**
	 * 数据库操作记录
	 */
	Logger loggerDao = LogFactory.getInstance().getLog("dao");
	
	/**
	 * 业务操作记录
	 */
	Logger loggerBiz = LogFactory.getInstance().getLog("biz");
	
	
	/**
	 * 控制层操作记录
	 */
	Logger loggerCtrl = LogFactory.getInstance().getLog("ctrl");
	
	/**
	 * 正常信息记录
	 */
	Logger loggerNormal = LogFactory.getInstance().getLog("normal");
	
	/**
	 * 接口信息记录
	 */
	Logger loggerWebservice = LogFactory.getInstance().getLog("webservice");
	
	/**
	 * 错误消息记录
	 */
	Logger loggerError = LogFactory.getInstance().getLog("error");
	
}