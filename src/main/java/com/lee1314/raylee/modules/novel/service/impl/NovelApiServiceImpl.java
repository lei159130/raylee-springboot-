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
		NovelApi api = mapper.selectByConnects();
		Map param = new HashMap<>();
		param.put("keyword", keyword);
		String result = HttpRequestUtils.doGet(api.getUrl() + SEARCH, param);
		Document doc = Jsoup.parse(result);
		Element resultList = doc.getElementsByClass("result-list").first();
		Elements items = resultList.getElementsByClass("result-item");
		List<Map> maps = new ArrayList<>();
		for (Element item : items) {
			Map<String, Object> map = new HashMap<>();
			Element img = item.getElementsByTag("img").first();
			Element link = item.getElementsByClass("result-game-item-title-link").first();
			Element desc = item.getElementsByClass("result-game-item-desc").first();

			String url = link.attr("href");
			url = url.substring(0, url.length() - 1);

			map.put("img", img.attr("src"));
			map.put("id", url.substring(url.lastIndexOf("/") + 1));
			map.put("title", link.attr("title"));
			map.put("desc", desc.text());
			maps.add(map);
		}
		return maps;
	}

	@Override
	public Map findMenus(Integer id) {
		NovelApi api = mapper.selectByConnects();
		String result = HttpRequestUtils.doGet(api.getUrl() + BOOK + "/" + id, null, "GB2312");
		Document doc = Jsoup.parse(result);
		Element list = doc.getElementById("list");
		Elements dds = list.getElementsByTag("dd");

		String title = list.getElementsByTag("dt").first().text();
		List<Map<String, String>> chapters = new ArrayList<>();
		for (Element dd : dds) {
			Map<String, String> map = new HashMap<>();
			map.put("title", dd.text());
			String url = dd.getElementsByTag("a").first().attr("href");
			map.put("id", url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")));
			chapters.add(map);
		}
		Map map = new HashMap<>();
		map.put("title", title);
		map.put("chapters", chapters);
		return map;
	}

	@Override
	public Map findText(Integer id, Integer chapter) {
		NovelApi api = mapper.selectByConnects();
		String result = HttpRequestUtils.doGet(api.getUrl() + BOOK + "/" + id + "/" + chapter + ".html", null,
				"GB2312");
		Document doc = Jsoup.parse(result);
		Element bookname = doc.getElementsByClass("bookname").first();
		Element bottem = bookname.getElementsByClass("bottem1").first();
		Elements as = bottem.getElementsByTag("a");
		String prevUrl = null;
		String nextUrl = null;
		for (Element a : as) {
			String text = a.text();
			String href = a.attr("href");
			if ("上一章".equals(text)) {
				prevUrl = href;
			} else if ("下一章".equals(text)) {
				nextUrl = href;
			} else {
				;
			}
		}

		Map map = new HashMap<>();
		map.put("content", doc.getElementById("content").html());
		map.put("title", bookname.getElementsByTag("h1").first().text());
		if (prevUrl.contains(".")) {
			map.put("prev", prevUrl.substring(prevUrl.lastIndexOf("/") + 1, prevUrl.lastIndexOf(".")));
		} else {
			map.put("next", null);
		}
		if (nextUrl.contains(".")) {
			map.put("next", nextUrl.substring(nextUrl.lastIndexOf("/") + 1, nextUrl.lastIndexOf(".")));
		} else {
			map.put("next", null);
		}
		return map;
	}

	@Override
	public List<Map> findHots() {
		NovelApi api = mapper.selectByConnects();
		String result = HttpRequestUtils.doGet(api.getUrl(), null, "GB2312");
		Document doc = Jsoup.parse(result);
		Element r = doc.getElementsByClass("r").first();
		Elements ul = r.getElementsByTag("li");
		List<Map> list = new ArrayList<>();
		for (Element li : ul) {
			Map map = new HashMap<>();
			Element s2 = li.getElementsByClass("s2").first();
			String url = s2.getElementsByTag("a").first().attr("href");
			url = url.substring(0, url.length() - 1);
			String type = li.getElementsByClass("s1").first().text();
			type = type.substring(1, type.length() - 1);

			map.put("type", type);
			map.put("title", s2.text());
			map.put("id", url.substring(url.lastIndexOf("/") + 1));
			map.put("author", li.getElementsByClass("s5").first().text());
			list.add(map);
		}
		return list;
	}

}
