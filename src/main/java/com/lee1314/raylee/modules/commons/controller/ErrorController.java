package com.lee1314.raylee.modules.commons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorController {

	@RequestMapping("400")
	public String skip400() {
		return "error/400";
	}

	@RequestMapping("404")
	public String skip404() {
		return "error/404";
	}

	@RequestMapping("500")
	public String skip500() {
		return "error/500";
	}

}
