/**
 * 
 */
package com.avalon.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @类名: SysUtil
 * @功能描述:系统工具类 
 * @类创建人: Mr
 * @类创建时间： 2015-8-19 下午02:18:54
 */
public class SysUtil {
	
	/**
	 * @方法名: CreateID 
	 * @功能描述: 主键生成工具 
	 * @param tableShort
	 * @return
	 * @创建人：成炜
	 * @创建时间： 2012
	 */
	public static String createID(String tableShort) {
		String id = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		id = format.format(date);
		String randomStr = "";
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			randomStr += r.nextInt(10);
		}
		id = id + "-" + randomStr + "-" + tableShort ;
		return id;
	}

	public static String createID2() {
		String id = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		id = format.format(date);
		String randomStr = "";
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			randomStr += r.nextInt(10);
		}
		id = id + "_" + randomStr;
		return id;
	}

}
