package com.lee1314.raylee.modules.audio.service.impl;

import com.lee1314.raylee.modules.audio.dao.mapper.PeopleDailyMapper;
import com.lee1314.raylee.modules.audio.pojo.entity.PeopleDaily;
import com.lee1314.raylee.modules.audio.service.PeopleDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PeopleDailyServiceImpl implements PeopleDailyService {

    private PeopleDailyMapper mapper;

    @Autowired
    public PeopleDailyServiceImpl(PeopleDailyMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<PeopleDaily> queryPeopleDaily(Integer seminarId, Integer id) {
        if (seminarId == null) {
            return Collections.EMPTY_LIST;
        }
        if (id == null) {
            id = mapper.selectNowIdBySeminarId(seminarId);
        }
        return mapper.selectPeopleDailys(seminarId, id);
    }
}
