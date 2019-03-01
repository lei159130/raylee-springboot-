package com.lee1314.raylee.modules.lovetree.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lee1314.raylee.constants.CodeMsg;
import com.lee1314.raylee.constants.Result;
import com.lee1314.raylee.modules.lovetree.model.LoveTree;
import com.lee1314.raylee.modules.lovetree.service.LoveTreeService;

/**
 * 爱情树Controller
 * 
 * @Title: LoveTreeController
 * @Description:
 * @Auther: 雷力
 * @Date: 2018-10-26 10:47:19
 *
 */
@Controller
@RequestMapping("lovetree")
public class LoveTreeController {

	@Value("${lovetreeUrl}")
	private String lovetreeUrl;
	@Autowired
	private LoveTreeService loveTreeService;

	@RequestMapping
	public String skipIndex(Model model) {
		LoveTree loveTree = loveTreeService.findLoveTreeByUrl(lovetreeUrl);
		model.addAttribute("lovetree", loveTree);
		return "lovetree/index";
	}

	@RequestMapping("form")
	public String skipForm() {
		return "lovetree/form";
	}

	@RequestMapping("{url}")
	public String skipMain(@PathVariable("url") String url, Model model) {
		LoveTree loveTree = loveTreeService.findLoveTreeByUrl(url);

		if (loveTree == null) {
			return "error/404";
		}

		model.addAttribute("lovetree", loveTree);
		return "lovetree/index";
	}

	@RequestMapping("add")
	public String Add(LoveTree loveTree) {
		loveTreeService.add(loveTree);
		return "redirect:/lovetree/" + loveTree.getUrl();
	}

	@RequestMapping("upload")
	@ResponseBody
	public Result<?> upload(@RequestParam CommonsMultipartFile file) {
		try {
			loveTreeService.saveAudio(file);
			return Result.success(file.getOriginalFilename());
		} catch (IOException e) {
			e.printStackTrace();
			return Result.error(new CodeMsg(e.hashCode(), e.getMessage()));
		}

		// 模拟上传
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { return
		 * Result.error(new CodeMsg(0, e.getMessage())); } return Result.success();
		 */
	}
}
