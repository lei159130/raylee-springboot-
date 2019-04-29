package com.lee1314.raylee.modules.commons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee1314.raylee.commons.cache.SysConfigChace;
import com.lee1314.raylee.constants.CodeMsg;
import com.lee1314.raylee.constants.Result;
import com.lee1314.raylee.utils.ParamUtils;
import com.lee1314.raylee.utils.SMSUtils;

@Controller
public class IndexController {

	@RequestMapping("")
	public String skipIndex() {
		return "index";
	}

	@RequestMapping("sendMessage")
	@ResponseBody
	public Result<?> sendMessage(String phone, String message) {
		try {
			ParamUtils.isPhone(phone, "手机号格式错误!");
			ParamUtils.isNotBlack(message, "内容不能为空!");
			return Result
					.success(SMSUtils.sendBaiWuMessage(SysConfigChace.get("phone"), "手机号:" + phone + ",内容:" + message));
		} catch (Exception e) {
			return Result.error(CodeMsg.PARAM_EXCEPTION, e.getMessage());
		}
	}
}
