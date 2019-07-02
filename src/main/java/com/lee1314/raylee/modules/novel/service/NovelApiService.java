package com.lee1314.raylee.modules.novel.service;

import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;

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
	static final String BOOK = "/book/";

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
	 * 查询小说章节目录Doc
	 * 
	 * @param id
	 * @return
	 */
	Document findChaptersDoc(Integer id);

	/**
	 * 查询小说名
	 * 
	 * @param doc
	 * @return
	 */
	String findBookTitle(Document doc, Integer id);

	/**
	 * 查询小说章节目录
	 * 
	 * @param doc
	 * @return
	 */
	List<Map> findChapters(Document doc);

	/**
	 * 查询小说章节
	 * 
	 * @param id
	 * @param chapterId
	 * @return
	 */
	Document findChapterDoc(Integer id, Integer chapterId);

	/**
	 * 获取小说内容
	 * 
	 * @param doc
	 * @return
	 */
	String findContent(Document doc);

	/**
	 * 获取上一章节id
	 * 
	 * @param doc
	 * @return
	 */
	String findChapterPrev(Document doc);

	/**
	 * 获取下一章节id
	 * 
	 * @param doc
	 * @return
	 */
	String findChapterNext(Document doc);
}
