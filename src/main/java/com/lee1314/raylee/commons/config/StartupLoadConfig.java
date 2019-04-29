package com.lee1314.raylee.commons.config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lee1314.raylee.commons.cache.SysConfigChace;
import com.lee1314.raylee.modules.sysconfig.model.SysConfig;
import com.lee1314.raylee.modules.sysconfig.service.SysConfigService;

/**
 * 程序启动加载数据库配置缓存
 * 
 * @title StartupLoadConfig
 * @author 雷力
 * @date 2019年4月29日下午2:51:10
 *
 */
@Component
public class StartupLoadConfig implements CommandLineRunner {
	@Autowired
	private SysConfigService sysConfigService;

	@Override
	public void run(String... args) throws Exception {
		SysConfigChace.set(sysConfigService.findAll().stream()
				.collect(Collectors.toMap(SysConfig::getCode, SysConfig::getContent)));
	}

}
