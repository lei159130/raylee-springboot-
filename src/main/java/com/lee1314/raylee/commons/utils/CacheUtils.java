package com.lee1314.raylee.commons.utils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheUtils {
    private static Map<String, Map<String, String>> cacheMap = new ConcurrentHashMap<>();

    public static void put(String key, String value) {
        Map<String, String> map = new HashMap<>();
        map.put("data", value);
        map.put("date", DateUtil.format(new Date(), DatePattern.ISO8601_FORMAT));
        cacheMap.put(key, map);
    }

    public static boolean containsKey(String key) {
        return cacheMap.containsKey(key);
    }

    @Scheduled(cron = "00 */10 * * * ?")
    public void execute() {
        Iterator<String> iterator = cacheMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Map<String, String> map = cacheMap.get(key);
            Date date = DateUtil.parse(map.get("date"), DatePattern.ISO8601_FORMAT);
            if (DateUtil.between(date, DateUtil.date(), DateUnit.MINUTE) > 30) {
                cacheMap.remove(key);
            }
        }
    }
}
