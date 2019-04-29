package com.lee1314.raylee.modules.sysconfig.service;

import java.util.List;

import com.lee1314.raylee.modules.sysconfig.model.SysConfig;

public interface SysConfigService {

	List<SysConfig> findAll();

	Integer update(SysConfig sysconfig);

}
