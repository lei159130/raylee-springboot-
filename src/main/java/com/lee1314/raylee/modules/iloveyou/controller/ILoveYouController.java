package com.lee1314.raylee.modules.iloveyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/iloveyou")
public class ILoveYouController {

	@RequestMapping("")
	public String skipIndex(Model model) {
		return "iloveyou/index";
	}
}
