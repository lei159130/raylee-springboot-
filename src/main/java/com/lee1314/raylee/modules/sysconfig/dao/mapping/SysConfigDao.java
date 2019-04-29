package com.lee1314.raylee.modules.sysconfig.dao.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lee1314.raylee.modules.commons.dao.BaseDao;
import com.lee1314.raylee.modules.sysconfig.model.SysConfig;

@Mapper
public interface SysConfigDao extends BaseDao<SysConfig> {

	List<SysConfig> selectAll();
}