package com.lee1314.raylee.modules.audio.service;


import com.lee1314.raylee.modules.audio.entity.PeopleDaily;

import java.util.List;

/**
 * @author leili
 */
public interface PeopleDailyService {
    List<PeopleDaily> queryPeopleDaily(Integer seminarId, Integer id);

    PeopleDaily queryNowIdBySeminarId(Integer seminarId);

    PeopleDaily queryPrevById(Integer seminarId, Integer id);

    PeopleDaily queryById(Integer id);

    PeopleDaily queryNextById(Integer seminarId, Integer id);
}
