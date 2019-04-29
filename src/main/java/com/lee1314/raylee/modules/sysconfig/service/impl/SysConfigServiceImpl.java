package com.lee1314.raylee.modules.sysconfig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee1314.raylee.commons.cache.SysConfigChace;
import com.lee1314.raylee.modules.sysconfig.dao.mapping.SysConfigDao;
import com.lee1314.raylee.modules.sysconfig.model.SysConfig;
import com.lee1314.raylee.modules.sysconfig.service.SysConfigService;

@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	private SysConfigDao mapper;

	@Override
	public List<SysConfig> findAll() {
		return mapper.selectAll();
	}

	@Override
	public Integer update(SysConfig sysconfig) {
		Integer count = mapper.updateByPrimaryKeySelective(sysconfig);
		if (count > 0) {
			SysConfigChace.set(sysconfig.getCode(), sysconfig.getContent());
		}
		return count;
	}
}
