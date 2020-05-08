package com.lee1314.raylee.modules.audio.service;

import com.lee1314.raylee.modules.audio.pojo.entity.PeopleDaily;

import java.util.List;

public interface PeopleDailyService {
    List<PeopleDaily> queryPeopleDailys(Integer seminarId, Integer id);
}
