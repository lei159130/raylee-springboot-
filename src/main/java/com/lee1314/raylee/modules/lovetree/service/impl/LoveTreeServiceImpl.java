package com.lee1314.raylee.modules.lovetree.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.baidubce.services.bos.model.PutObjectResponse;
import com.lee1314.raylee.modules.lovetree.dao.LoveTreeDao;
import com.lee1314.raylee.modules.lovetree.model.LoveTree;
import com.lee1314.raylee.modules.lovetree.service.LoveTreeService;
import com.lee1314.raylee.utils.BocUtils;

@Service
public class LoveTreeServiceImpl implements LoveTreeService {

	@Autowired
	LoveTreeDao mapper;

	@Override
	public LoveTree findLoveTreeById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public LoveTree findLoveTreeByUrl(String url) {
		LoveTree loveTree = mapper.selectByURL(url);
		if (loveTree == null) {
			return null;
		}
		url = BocUtils.getInstance().generatePresignedUrl(BocUtils.bucketname, loveTree.getFileName(), 1800).toString();
		loveTree.setUrl(url);
		return loveTree;
	}

	@Override
	public PutObjectResponse saveAudio(CommonsMultipartFile file) throws IOException {
		return BocUtils.getInstance().putObject(BocUtils.bucketname, file.getOriginalFilename(), file.getInputStream());
	}

	@Override
	public Integer add(LoveTree loveTree) {
		return mapper.insert(loveTree);
	}

}
