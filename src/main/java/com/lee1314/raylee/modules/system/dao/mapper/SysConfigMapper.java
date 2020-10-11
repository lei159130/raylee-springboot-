package com.lee1314.raylee.modules.system.dao.mapper;

import com.lee1314.raylee.modules.system.pojo.entity.SysConfig;

import com.lee1314.raylee.modules.system.pojo.entity.example.SysConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysConfigMapper {
    long countByExample(SysConfigExample example);

    int deleteByExample(SysConfigExample example);

    int deleteByPrimaryKey(@Param("business") String business, @Param("code") String code);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    List<SysConfig> selectByExample(SysConfigExample example);

    SysConfig selectByPrimaryKey(@Param("business") String business, @Param("code") String code);

    int updateByExampleSelective(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

    int updateByExample(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);
}