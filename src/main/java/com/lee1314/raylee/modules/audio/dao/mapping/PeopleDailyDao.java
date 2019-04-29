package com.lee1314.raylee.modules.audio.dao.mapping;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lee1314.raylee.modules.audio.model.PeopleDaily;
import com.lee1314.raylee.modules.commons.dao.BaseDao;

/**
 * 人民日报Mapper
 * 
 * @author 雷力
 * @date 2019年1月17日 下午4:03:00
 */
@Mapper
public interface PeopleDailyDao extends BaseDao<PeopleDaily> {

	/**
	 * 获取最新数据ID
	 * 
	 * @return
	 */
	Long selectNewId(@Param("seminarId") Integer seminarId);

	/**
	 * 获取上一条数据ID
	 * 
	 * @param currentId
	 * @return
	 */
	Long selectPrevId(@Param("id") Long id, @Param("seminarId") Integer seminarId);

	/**
	 * 获取下一条数据ID
	 * 
	 * @param currentId
	 * @return
	 */
	Long selectNextId(@Param("id") Long id, @Param("seminarId") Integer seminarId);
}