package com.lee1314.raylee.commons.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * menus缓存类
 * 
 * @Title: MenusCache
 * @Description:
 * @author: 雷力
 * @date: 2019年1月25日 下午1:55:35
 *
 */
public class MenusCache {

	public static Map<String, Object> cacheMap = new ConcurrentHashMap<>();

	public static void destoryCacheMap() {
		cacheMap = null;
	}

	public static Map<String, Object> getCacheMap() {
		return cacheMap;
	}

	public static void set(String key, Object values) {
		cacheMap.put(key, values);
	}

	public static Object get(String key) {
		return cacheMap.get(key);
	}

	public static String getString(String key) {
		return (String) cacheMap.get(key);
	}

	public static Object getToEmpty(String key) {
		Object o = cacheMap.get(key);
		if (o == null)
			return "";
		else
			return o;
	}

	public static void remove(String key) {
		cacheMap.remove(key);
	}

	public static void clear() {
		cacheMap.clear();
	}

}
