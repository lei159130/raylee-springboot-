package com.lee1314.raylee.modules.audio.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lee1314.raylee.modules.audio.dao.mapper.PeopleDailyMapper;
import com.lee1314.raylee.modules.audio.entity.PeopleDaily;
import com.lee1314.raylee.modules.audio.service.PeopleDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author leili
 */
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
            id = queryNowIdBySeminarId(seminarId).getId();
        }
        List<PeopleDaily> entitys = new ArrayList<>();
        PeopleDaily prev = queryPrevById(seminarId, id),
                current = queryById(id),
                next = queryNextById(seminarId, id);
        if (prev != null) {
            entitys.add(prev);
        }
        if (current != null) {
            entitys.add(current);
        }
        if (next != null) {
            entitys.add(next);
        }
        return entitys;
    }

    @Override
    public PeopleDaily queryNowIdBySeminarId(Integer seminarId) {
        QueryWrapper<PeopleDaily> wrapper = new QueryWrapper();
        wrapper.eq("seminar_id", seminarId).orderByAsc("id").last("limit 1");
        return mapper.selectOne(wrapper);
    }

    @Override
    public PeopleDaily queryPrevById(Integer seminarId, Integer id) {
        QueryWrapper<PeopleDaily> wrapper = new QueryWrapper();
        wrapper.eq("seminar_id", seminarId).gt("id", id).orderByDesc("id").last("limit 1");
        return mapper.selectOne(wrapper);
    }

    @Override
    public PeopleDaily queryById(Integer id) {
        QueryWrapper<PeopleDaily> wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        return mapper.selectOne(wrapper);
    }

    @Override
    public PeopleDaily queryNextById(Integer seminarId, Integer id) {
        QueryWrapper<PeopleDaily> wrapper = new QueryWrapper();
        wrapper.eq("seminar_id", seminarId).lt("id", id).orderByAsc("id").last("limit 1");
        return mapper.selectOne(wrapper);
    }
}
