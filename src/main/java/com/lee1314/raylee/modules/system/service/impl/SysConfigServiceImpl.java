package com.lee1314.raylee.modules.system.service.impl;

import com.lee1314.raylee.modules.system.dao.mapper.SysConfigMapper;
import com.lee1314.raylee.modules.system.pojo.entity.SysConfig;
import com.lee1314.raylee.modules.system.pojo.entity.example.SysConfigExample;
import com.lee1314.raylee.modules.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private SysConfigMapper mapper;

    @Override
    public SysConfig queryByBusinessAndCode(String business, String code) {
        SysConfigExample example = new SysConfigExample();
        SysConfigExample.Criteria criteria = example.createCriteria();
        criteria.andBusinessEqualTo(business);
        criteria.andCodeEqualTo(code);
        List<SysConfig> sysConfigs = mapper.selectByExample(example);
        if (sysConfigs.isEmpty()) {
            return null;
        }
        return sysConfigs.get(0);
    }
}
