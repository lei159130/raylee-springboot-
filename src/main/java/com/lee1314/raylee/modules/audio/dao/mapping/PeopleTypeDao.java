package com.lee1314.raylee.modules.audio.dao.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lee1314.raylee.modules.audio.model.PeopleType;
import com.lee1314.raylee.modules.commons.dao.BaseDao;

/**
 * 人民日报Type Mapeer
 * 
 * @Title: PeopleTypeMapper
 * @Description:
 * @author: 雷力
 * @date: 2019年1月24日 下午4:28:41
 *
 */
@Mapper
public interface PeopleTypeDao extends BaseDao<PeopleType> {

	/**
	 * 获取所有Menus
	 * 
	 * @return
	 */
	List<PeopleType> selectAllMenus();
}