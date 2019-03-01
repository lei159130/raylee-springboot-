package com.lee1314.raylee.utils;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

public class IdUtils {

	private static String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * UUID
	 * 
	 * @return
	 */
	public static String uuids() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 获取验证码
	 * 
	 * @param num 验证码位数
	 * @return
	 */
	public static String PIN(int num) {
		return RandomStringUtils.random(num, str.toCharArray());
	}

	/**
	 * 获取默认6位验证码
	 * 
	 * @return
	 */
	public static String PIN() {
		return PIN(6);
	}

	public static void main(String[] args) {
		System.out.println(uuids());
		System.out.println(PIN(6));
	}
}
