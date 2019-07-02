package com.lee1314.raylee.modules.novel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee1314.raylee.modules.novel.dao.mapping.NovelApiDao;
import com.lee1314.raylee.modules.novel.model.NovelApi;
import com.lee1314.raylee.modules.novel.service.NovelApiService;
import com.lee1314.raylee.utils.HttpRequestUtils;

@SuppressWarnings(value = { "rawtypes", "unchecked" })
@Service
public class NovelApiServiceImpl implements NovelApiService {

	@Autowired
	private NovelApiDao mapper;

	@Override
	public List<NovelApi> findUrls() {
		return mapper.selectUrls();
	}

	@Override
	public List<Map> findListByKW(String keyword) {
		List<Map> maps = new ArrayList<>();

		NovelApi api = mapper.selectByConnects();
		String result = HttpRequestUtils.doGet(api.getUrl() + keyword, null);
		Document doc = Jsoup.parse(result);
		Elements hotSales = doc.select(".mybook>.hot_sale");
		for (Element hotSale : hotSales) {
			Element a = hotSale.select("a").first();
			Element title = hotSale.select(".title").first();
			Element author = hotSale.select(".author").first();

			Map<String, String> map = new HashMap<>();
			String url = a.attr("href");
			map.put("id", url.substring(url.lastIndexOf("/") + 1, url.length()));
			map.put("title", title.text());
			map.put("author", author.text());

			maps.add(map);
		}
		return maps;
	}

	@Override
	public Document findChaptersDoc(Integer id) {
		NovelApi api = mapper.selectByConnects();
		String result = HttpRequestUtils.doGet(api.getHost() + BOOK + id, null);
		return Jsoup.parse(result);
	}

	@Override
	public String findBookTitle(Document doc, Integer id) {
		String title = doc.select(".book a[href=/book/" + id + "/]").first().text();
		return title.replace("最新章节", "");
	}

	@Override
	public List<Map> findChapters(Document doc) {
		List<Map> maps = new ArrayList<>();

		Elements chapters = doc.select(".listmain dd:gt(6)");
		for (Element chapter : chapters) {
			Map map = new HashMap<>();
			Element a = chapter.select("a").first();
			String url = a.attr("href");

			map.put("id", url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")));
			map.put("title", a.text());

			maps.add(map);
		}
		return maps;
	}

	@Override
	public Document findChapterDoc(Integer id, Integer chapterId) {
		NovelApi api = mapper.selectByConnects();
		String result = HttpRequestUtils.doGet(api.getHost() + BOOK + id + "/" + chapterId + ".html", null, "gbk");
		return Jsoup.parse(result);
	}

	@Override
	public String findContent(Document doc) {
		String content = doc.select("#content").first().text();
		return content.substring(0, content.lastIndexOf("https"));
	}

	@Override
	public String findChapterPrev(Document doc) {
		String url = doc.select(".page_chapter a").get(0).attr("href");
		return url.lastIndexOf(".") > 0 ? url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")) : "";
	}

	@Override
	public String findChapterNext(Document doc) {
		String url = doc.select(".page_chapter a").get(2).attr("href");
		return url.lastIndexOf(".") > 0 ? url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")) : "";
	}

}
