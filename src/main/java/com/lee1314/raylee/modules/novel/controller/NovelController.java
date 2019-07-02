package com.lee1314.raylee.modules.novel.controller;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lee1314.raylee.modules.novel.service.NovelApiService;

@Controller
@RequestMapping("novel")
public class NovelController {

	@Autowired
	private NovelApiService novelApiService;

	@RequestMapping
	public String skipIndex(Model model) {
		return "novel/index";
	}

	@RequestMapping("search")
	public String skiplist(Model model, String keyword) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("items", novelApiService.findListByKW(keyword));
		return "novel/books";
	}

	@RequestMapping("book/{id}")
	public String skipBook(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("id", id);
		Document doc = novelApiService.findChaptersDoc(id);
		model.addAttribute("title", novelApiService.findBookTitle(doc, id));
		model.addAttribute("chapters", novelApiService.findChapters(doc));
		return "novel/book";
	}

	@RequestMapping("book/{id}/{chapter}")
	public String skipChapter(Model model, @PathVariable("id") Integer id, @PathVariable("chapter") Integer chapterId) {
		model.addAttribute("id", id);
		Document doc = novelApiService.findChapterDoc(id, chapterId);
		model.addAttribute("title", novelApiService.findBookTitle(doc, id));
		model.addAttribute("content", novelApiService.findContent(doc));
		model.addAttribute("prev", novelApiService.findChapterPrev(doc));
		model.addAttribute("next", novelApiService.findChapterNext(doc));
		return "novel/chapter";
	}
}
