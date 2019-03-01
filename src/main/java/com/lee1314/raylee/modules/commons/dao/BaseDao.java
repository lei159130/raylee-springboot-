package com.lee1314.raylee.modules.commons.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 基础Mapper
 * 
 * @Title: BaseMapper
 * @Description:
 * @Auther: 雷力
 * @Date: 2018-12-06 09:28:46
 *
 * @param <T>
 */
@Mapper
public interface BaseDao<T> {
	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 添加数据
	 * 
	 * @param record
	 * @return
	 */
	int insert(T record);

	/**
	 * 添加非空数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(T record);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(Long id);

	/**
	 * 修改非空数据
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(T record);

	/**
	 * 修改所有数据
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(T record);
}
