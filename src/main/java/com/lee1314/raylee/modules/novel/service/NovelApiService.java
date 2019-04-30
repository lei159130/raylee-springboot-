package com.lee1314.raylee.modules.novel.service;

import java.util.List;
import java.util.Map;

import com.lee1314.raylee.modules.novel.model.NovelApi;

/**
 * 小说Service
 * 
 * @title NovelApiService
 * @author 雷力
 * @date 2019年3月2日下午2:03:39
 *
 */
@SuppressWarnings("rawtypes")
public interface NovelApiService {

	static final String SEARCH = "/search.php";
	static final String BOOK = "/book";

	/**
	 * 查询所有的API
	 * 
	 * @return
	 */
	List<NovelApi> findUrls();

	/**
	 * 根据关键字查询小说集合
	 * 
	 * @param keyword
	 * @return
	 */
	List<Map> findListByKW(String keyword);

	/**
	 * 查询小说章节目录
	 * 
	 * @param id
	 * @return
	 */
	Map findMenus(Integer id);

	/**
	 * 查询小说正文
	 * 
	 * @param id
	 * @param chapter
	 * @return
	 */
	Map findText(Integer id, Integer chapter);

	/**
	 * 获取热门小说
	 * 
	 * @return
	 */
	List<Map> findHots();

}
