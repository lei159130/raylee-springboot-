package com.lee1314.raylee.utils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

/**
 * 百度短链接参数
 * 
 * @Title: BaiDuShortURL
 * @Description:
 * @Auther: 雷力
 * @Date: 2018-10-25 15:43:06
 *
 */
public class ShortUrlUtils {

	/**
	 * 生成接口
	 */
	private static final String CREATE_URL = "https://dwz.cn/admin/create";

	/**
	 * 还原接口
	 */
	private static final String QUERY_URL = "https://dwz.cn/admin/query";

	/**
	 * Content-Type
	 */
	private static final String CONTENT_TYPE = "application/json; charset=UTF-8";

	public static String shortToLong(String url) throws ClientProtocolException, IOException {
		Map<String, String> param = new LinkedHashMap<>();
		param.put("url", url);
		return HttpRequestUtils.doPost(QUERY_URL, param, CONTENT_TYPE);
	}

	public static String longToShort(String url) throws ClientProtocolException, IOException {
		Map<String, String> param = new LinkedHashMap<>();
		param.put("url", url);
		return HttpRequestUtils.doPost(CREATE_URL, param, CONTENT_TYPE);
	}

}
