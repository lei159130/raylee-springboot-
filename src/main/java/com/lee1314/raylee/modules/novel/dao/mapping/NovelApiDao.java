package com.lee1314.raylee.modules.novel.dao.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lee1314.raylee.modules.commons.dao.BaseDao;
import com.lee1314.raylee.modules.novel.model.NovelApi;

/**
 * 小说Mapper
 * 
 * @title NovelApiMapper
 * @author 雷力
 * @date 2019年3月2日下午2:03:51
 *
 */
@Mapper
public interface NovelApiDao extends BaseDao<NovelApi> {

	/**
	 * 查询所有URLS
	 * 
	 * @return
	 */
	List<NovelApi> selectUrls();

	/**
	 * 查询最高连通率API
	 * 
	 * @return
	 */
	NovelApi selectByConnects();
}