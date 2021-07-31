package com.lee1314.raylee.modules.audio.controller;

import com.lee1314.raylee.commons.pojo.dto.ResponseDto;
import com.lee1314.raylee.modules.audio.entity.PeopleDaily;
import com.lee1314.raylee.modules.audio.service.PeopleDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leili
 */
@RestController
@RequestMapping("peopleDaily")
public class PeopleDailyController {

    private PeopleDailyService service;

    @Autowired
    public PeopleDailyController(PeopleDailyService service) {
        this.service = service;
    }

    @PostMapping("query")
    public ResponseDto<?> getPeopleDaily(@RequestBody PeopleDaily entity) {
        try {
            return ResponseDto.success(service.queryPeopleDaily(entity.getSeminarId(), entity.getId()));
        } catch (Exception e) {
            return ResponseDto.error("系统异常，请稍后再试!");
        }
    }
}
