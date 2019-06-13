package com.lee1314.raylee.modules.mota.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mota")
public class MotaController {

	@RequestMapping
	public String skipIndex(Model model) {
		return "mota/index";
	}
}
