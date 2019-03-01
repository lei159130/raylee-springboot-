package com.lee1314.raylee.modules.lovetree.service;

import java.io.IOException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.baidubce.services.bos.model.PutObjectResponse;
import com.lee1314.raylee.modules.lovetree.model.LoveTree;

/**
 * 爱情树
 * 
 * @Title: LoveTreeService
 * @Description:
 * @Auther: 雷力
 * @Date: 2018-10-25 20:30:41
 *
 */
public interface LoveTreeService {

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	LoveTree findLoveTreeById(Long id);

	/**
	 * 根据url查询
	 * 
	 * @param url 链接
	 * @return
	 */
	LoveTree findLoveTreeByUrl(String url);

	/**
	 * 保存音频文件(上传百度)
	 * 
	 * @param file 文件
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	PutObjectResponse saveAudio(CommonsMultipartFile file) throws IOException;

	/**
	 * 添加
	 * 
	 * @param loveTree
	 * @return
	 */
	Integer add(LoveTree loveTree);

}
