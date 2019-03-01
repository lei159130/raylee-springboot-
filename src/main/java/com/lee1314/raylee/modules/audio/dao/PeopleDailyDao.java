package com.lee1314.raylee.modules.audio.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lee1314.raylee.modules.audio.model.PeopleDaily;

/**
 * 人民日报Mapper
 * 
 * @author 雷力
 * @date 2019年1月17日 下午4:03:00
 */
@Mapper
public interface PeopleDailyDao {
	int deleteByPrimaryKey(Integer id);

	int insert(PeopleDaily record);

	int insertSelective(PeopleDaily record);

	PeopleDaily selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(PeopleDaily record);

	int updateByPrimaryKeyWithBLOBs(PeopleDaily record);

	int updateByPrimaryKey(PeopleDaily record);

	/**
	 * 获取最新数据ID
	 * 
	 * @return
	 */
	Integer selectNewId(@Param("seminarId") Integer seminarId);

	/**
	 * 获取上一条数据ID
	 * 
	 * @param currentId
	 * @return
	 */
	Integer selectPrevId(@Param("id") Integer id, @Param("seminarId") Integer seminarId);

	/**
	 * 获取下一条数据ID
	 * 
	 * @param currentId
	 * @return
	 */
	Integer selectNextId(@Param("id") Integer id, @Param("seminarId") Integer seminarId);
}