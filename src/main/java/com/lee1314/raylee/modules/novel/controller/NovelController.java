package com.lee1314.raylee.modules.novel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lee1314.raylee.modules.novel.model.NovelApi;
import com.lee1314.raylee.modules.novel.service.NovelApiService;

@Controller
@RequestMapping("novel")
public class NovelController {

	@Autowired
	private NovelApiService novelApiService;

	@RequestMapping
	public String skipIndex(Model model) {
		List<NovelApi> apis = novelApiService.findUrls();
		model.addAttribute("apis", apis);
		return "novel/index";
	}

	@RequestMapping("search")
	public String skiplist(Model model, String keyword) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("items", novelApiService.findListByKW(keyword));
		model.addAttribute("hots", novelApiService.findHots());
		return "novel/books";
	}

	@RequestMapping("book/{id}")
	public String skipBook(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("id", id);
		model.addAttribute("book", novelApiService.findMenus(id));
		return "novel/book";
	}

	@RequestMapping("book/{id}/{chapter}")
	public String skipChapter(Model model, @PathVariable("id") Integer id, @PathVariable("chapter") Integer chapter) {
		model.addAttribute("id", id);
		model.addAttribute("book", novelApiService.findText(id, chapter));
		return "novel/chapter";
	}
}
