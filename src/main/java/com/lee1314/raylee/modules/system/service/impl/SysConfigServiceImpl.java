package com.lee1314.raylee.modules.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lee1314.raylee.modules.system.dao.mapper.SysConfigMapper;
import com.lee1314.raylee.modules.system.pojo.entity.SysConfig;
import com.lee1314.raylee.modules.system.pojo.entity.example.SysConfigExample;
import com.lee1314.raylee.modules.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private SysConfigMapper mapper;

    @Override
    public JSONArray queryMenus() {
        return JSON.parseArray(mapper.selectByPrimaryKey("peopledaily", "paramvalue").getContent());
    }
}
