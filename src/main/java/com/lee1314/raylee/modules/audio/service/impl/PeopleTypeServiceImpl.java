package com.lee1314.raylee.modules.audio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee1314.raylee.commons.cache.MenusCache;
import com.lee1314.raylee.modules.audio.dao.mapping.PeopleTypeDao;
import com.lee1314.raylee.modules.audio.model.PeopleType;
import com.lee1314.raylee.modules.audio.service.PeopleTypeService;

/**
 * 人民日报Type ServiceImpl
 * 
 * @Title: PeopleTypeServiceImpl
 * @Description:
 * @author: 雷力
 * @date: 2019年1月25日 下午2:09:02
 *
 */
@Service
public class PeopleTypeServiceImpl implements PeopleTypeService {

	@Autowired
	private PeopleTypeDao mapper;

	@SuppressWarnings("unchecked")
	@Override
	public List<PeopleType> findAllMenus() {
		if (MenusCache.get("menus") == null) {
			MenusCache.set("menus", mapper.selectAllMenus());
		}

		return (List<PeopleType>) MenusCache.get("menus");
	}

}
