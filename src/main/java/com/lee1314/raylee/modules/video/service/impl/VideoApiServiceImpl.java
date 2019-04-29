package com.lee1314.raylee.modules.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee1314.raylee.modules.video.dao.mapping.VideoApiDao;
import com.lee1314.raylee.modules.video.model.VideoApi;
import com.lee1314.raylee.modules.video.service.VideoApiService;

@Service
public class VideoApiServiceImpl implements VideoApiService {

	@Autowired
	private VideoApiDao mapper;

	@Override
	public List<VideoApi> findUrls() {
		return mapper.selectUrls();
	}

}
