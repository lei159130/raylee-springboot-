package com.lee1314.raylee.modules.audio.service;

import java.util.List;

import com.lee1314.raylee.modules.audio.pojo.entity.PeopleDaily;

public interface PeopleDailyService {
	List<PeopleDaily> queryPeopleDailys(Integer seminarId, Integer id);
}
