package com.lee1314.raylee.modules.video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lee1314.raylee.commons.cache.SysConfigChace;
import com.lee1314.raylee.modules.video.model.VideoApi;
import com.lee1314.raylee.modules.video.service.VideoApiService;

/**
 * 视频Controller
 * 
 * @Title: MovieController
 * @Description:
 * @author: 雷力
 * @date: 2018年12月7日 下午1:38:07
 *
 */
@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private VideoApiService videoApiService;

	@RequestMapping
	public String skipIndex(Model model) {
		List<VideoApi> videoApis = videoApiService.findUrls();
		model.addAttribute("api", videoApis.get(0).getUrl());
		model.addAttribute("url", SysConfigChace.get("videoUrl"));
		model.addAttribute("videoApis", videoApis);
		return "video/index";
	}
}
