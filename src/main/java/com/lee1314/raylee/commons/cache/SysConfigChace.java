package com.lee1314.raylee.commons.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统配置缓存类
 * 
 * @title StringChace
 * @author 雷力
 * @date 2019年4月29日下午2:02:07
 *
 */
public final class SysConfigChace {

	public static Map<String, String> cacheMap = new ConcurrentHashMap<>();

	public static void destoryCacheMap() {
		cacheMap = null;
	}

	public static Map<String, String> getCacheMap() {
		return cacheMap;
	}

	public static void set(String key, String values) {
		cacheMap.put(key, values);
	}

	public static void set(Map<String, String> map) {
		map.forEach((key, value) -> {
			cacheMap.put(key, value);
		});
	}

	public static String get(String key) {
		return cacheMap.get(key);
	}

	public static void remove(String key) {
		cacheMap.remove(key);
	}

	public static void clear() {
		cacheMap.clear();
	}

}
