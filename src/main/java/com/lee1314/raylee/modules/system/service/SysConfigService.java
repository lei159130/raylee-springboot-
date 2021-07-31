package com.lee1314.raylee.modules.system.service;

import com.lee1314.raylee.modules.system.entity.SysConfig;

public interface SysConfigService {
    SysConfig queryByBusinessAndCode(String business, String code);
}
