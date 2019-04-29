package com.lee1314.raylee.modules.audio.service;

import com.lee1314.raylee.modules.audio.model.PeopleDaily;

/**
 * 人民日报Service
 * 
 * @author 雷力
 * @date 2019年1月17日 下午4:09:24
 */
public interface PeopleDailyService {

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	PeopleDaily findById(Long id) throws Exception;

	/**
	 * 获取最新一条数据的ID
	 * 
	 * @return
	 */
	Long findNewID(Integer seminarId);

	/**
	 * 获取当前ID上一条数据
	 * 
	 * @param currentId
	 * @return
	 * @throws Exception
	 */
	Long findPrevId(Long id, Integer seminarId) throws Exception;

	/**
	 * 获取当前ID下一条数据
	 * 
	 * @param currentId
	 * @return
	 * @throws Exception
	 */
	Long findNextId(Long id, Integer seminarId) throws Exception;

	/**
	 * 获取当前id上一条加密后的id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String findEncodePrevId(Long id, Integer seminarId) throws Exception;

	/**
	 * 获取当前id下一条加密后的id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String findEncodeNextId(Long id, Integer seminarId) throws Exception;

}
