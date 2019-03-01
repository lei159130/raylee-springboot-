package com.lee1314.raylee.modules.audio.service;

import java.util.List;

import com.lee1314.raylee.modules.audio.model.PeopleType;

/**
 * 人民日报Type Service
 * 
 * @Title: PeopleTypeService
 * @Description:
 * @author: 雷力
 * @date: 2019年1月24日 下午4:27:10
 *
 */
public interface PeopleTypeService {

	/**
	 * 获取所有Menus
	 * 
	 * @return
	 */
	List<PeopleType> findAllMenus();

}
