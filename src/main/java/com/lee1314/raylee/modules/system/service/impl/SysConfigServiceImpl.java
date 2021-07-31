package com.lee1314.raylee.modules.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lee1314.raylee.modules.system.dao.mapper.SysConfigMapper;
import com.lee1314.raylee.modules.system.entity.SysConfig;
import com.lee1314.raylee.modules.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author leili
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

    private SysConfigMapper mapper;
    private RedisTemplate redisTemplate;

    @Autowired
    public SysConfigServiceImpl(SysConfigMapper mapper, RedisTemplate redisTemplate) {
        this.mapper = mapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public SysConfig queryByBusinessAndCode(String business, String code) {
        String k = "system:config", hk = business + "_" + code;
        Object value = redisTemplate.opsForHash().get(k, hk);
        if (value != null) {
            return ((JSONObject) value).toJavaObject(SysConfig.class);
        }
        QueryWrapper<SysConfig> wrapper = new QueryWrapper<>();
        wrapper.eq("business", business).eq("code", code);
        SysConfig sysConfig = mapper.selectOne(wrapper);
        if (sysConfig != null) {
            redisTemplate.opsForHash().put(k, hk, sysConfig);
            return sysConfig;
        }
        return null;
    }
}
