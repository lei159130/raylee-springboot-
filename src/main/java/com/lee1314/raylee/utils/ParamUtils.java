package com.lee1314.raylee.utils;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 参数工具类
 * 
 * @Title: ParamUtils
 * @Description:
 * @author: 雷力
 * @date: 2018-12-26 11:58:29
 *
 */
public class ParamUtils {

	private static String phoneReg = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";

	/**
	 * 是否为空
	 * 
	 * @param param
	 *            校验参数
	 * @param msg
	 *            消息
	 * @return
	 */
	public static boolean isNotBlack(String param, String msg) {
		if (StringUtils.isNotBlank(param)) {
			return true;
		} else {
			throw new RuntimeException(msg);
		}
	}

	/**
	 * 是否为手机号
	 * 
	 * @param phone
	 *            手机号
	 * @param msg
	 *            消息
	 * @return
	 */
	public static boolean isPhone(String phone, String msg) {
		if (Pattern.matches(phoneReg, phone)) {
			return true;
		} else {
			throw new RuntimeException(msg);
		}
	}
}
