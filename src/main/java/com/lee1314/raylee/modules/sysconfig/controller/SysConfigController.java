package com.lee1314.raylee.modules.sysconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee1314.raylee.constants.CodeMsg;
import com.lee1314.raylee.constants.Result;
import com.lee1314.raylee.modules.sysconfig.model.SysConfig;
import com.lee1314.raylee.modules.sysconfig.service.SysConfigService;

@Controller
@RequestMapping("sysconfig")
public class SysConfigController {

	@Autowired
	private SysConfigService sysConfigService;

	@RequestMapping("")
	public String skipIndex() {
		return "system/index";
	}

	@RequestMapping(value = "list", method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> lists() {
		return Result.success(sysConfigService.findAll());
	}

	@RequestMapping(value = "update", method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> update(SysConfig sysconfig) {
		if (sysConfigService.update(sysconfig) > 0) {
			return Result.success();
		} else {
			return Result.error(CodeMsg.SERVER_EXCEPTION);
		}
	}
}
