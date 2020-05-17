package com.lee1314.raylee.modules.audio.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee1314.raylee.modules.audio.dao.mapper.PeopleDailyMapper;
import com.lee1314.raylee.modules.audio.pojo.entity.PeopleDaily;
import com.lee1314.raylee.modules.audio.service.PeopleDailyService;

@Service
public class PeopleDailyServiceImpl implements PeopleDailyService {
	@Autowired
	private PeopleDailyMapper mapper;

	@Override
	public List<PeopleDaily> queryPeopleDailys(Integer seminarId, Integer id) {
		if (seminarId == null) {
			return Collections.EMPTY_LIST;
		}
		if (id == null) {
			id = mapper.selectNowIdBySeminarId(seminarId);
		}
		return mapper.selectPeopleDailys(seminarId, id);
	}
}
