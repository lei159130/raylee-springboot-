package com.lee1314.raylee.modules.audio.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lee1314.raylee.modules.audio.pojo.entity.PeopleDaily;
import com.lee1314.raylee.modules.audio.pojo.entity.example.PeopleDailyExample;

public interface PeopleDailyMapper {

	long countByExample(PeopleDailyExample example);

	int deleteByExample(PeopleDailyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(PeopleDaily record);

	int insertSelective(PeopleDaily record);

	List<PeopleDaily> selectByExampleWithBLOBs(PeopleDailyExample example);

	List<PeopleDaily> selectByExample(PeopleDailyExample example);

	PeopleDaily selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") PeopleDaily record, @Param("example") PeopleDailyExample example);

	int updateByExampleWithBLOBs(@Param("record") PeopleDaily record, @Param("example") PeopleDailyExample example);

	int updateByExample(@Param("record") PeopleDaily record, @Param("example") PeopleDailyExample example);

	int updateByPrimaryKeySelective(PeopleDaily record);

	int updateByPrimaryKeyWithBLOBs(PeopleDaily record);

	int updateByPrimaryKey(PeopleDaily record);

	@Select("SELECT id FROM people_daily WHERE seminar_id = #{seminarId,jdbcType=INTEGER} ORDER BY id DESC LIMIT 0,1")
	Integer selectNowIdBySeminarId(@Param("seminarId") Integer seminarId);

	@Select("SELECT id, title, audio_play_time AS audioPlayTime, audio_url AS audioUrl, comment_count AS commentCount, share_url AS shareUrl, seminar_id AS seminarId, content FROM people_daily WHERE id IN (( SELECT id FROM people_daily WHERE seminar_id = #{seminarId,jdbcType=INTEGER} AND id < #{id,jdbcType=INTEGER} ORDER BY id DESC LIMIT 1), #{id,jdbcType=INTEGER},( SELECT id FROM people_daily WHERE seminar_id = #{seminarId,jdbcType=INTEGER} AND id > #{id,jdbcType=INTEGER} ORDER BY id ASC LIMIT 1 )) ORDER BY id DESC")
	List<PeopleDaily> selectPeopleDailys(@Param("seminarId") Integer seminarId, @Param("id") Integer id);
}