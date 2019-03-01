package com.lee1314.raylee.modules.video.service;

import java.util.List;

import com.lee1314.raylee.modules.video.model.VideoApi;

/**
 * 
 * @Title: MovieApiService
 * @Description:
 * @author: 雷力
 * @date: 2018年12月7日 下午1:35:23
 *
 */
public interface VideoApiService {

	/**
	 * 查询电影接口
	 * 
	 * @return
	 */
	List<VideoApi> findUrls();

}
