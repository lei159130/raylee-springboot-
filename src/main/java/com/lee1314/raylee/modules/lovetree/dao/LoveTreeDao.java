package com.lee1314.raylee.modules.lovetree.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lee1314.raylee.modules.commons.dao.BaseDao;
import com.lee1314.raylee.modules.lovetree.model.LoveTree;

/**
 * 爱情树Mapper
 * 
 * @Title: LoveTreeMapper
 * @Description:
 * @Auther: 雷力
 * @Date: 2018-12-06 09:23:58
 *
 */
@Mapper
public interface LoveTreeDao extends BaseDao<LoveTree> {
	/**
	 * 根据url查询
	 * 
	 * @param url
	 * @return
	 */
	LoveTree selectByURL(@Param("url") String url);
}