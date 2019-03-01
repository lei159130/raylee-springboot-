package com.lee1314.raylee.modules.video.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lee1314.raylee.modules.commons.dao.BaseDao;
import com.lee1314.raylee.modules.video.model.VideoApi;

/**
 * 电影接口Mapper
 * 
 * @Title: MovieApiMapper
 * @Description:
 * @Auther: 雷力
 * @Date: 2018-12-06 09:29:03
 *
 */
@Mapper
public interface VideoApiDao extends BaseDao<VideoApi> {

	/**
	 * 查询电影接口
	 * 
	 * @return
	 */
	List<VideoApi> selectUrls();
}