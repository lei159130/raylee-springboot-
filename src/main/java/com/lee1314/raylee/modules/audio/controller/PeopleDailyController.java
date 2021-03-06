package com.lee1314.raylee.modules.audio.controller;

import com.lee1314.raylee.commons.pojo.dto.ResponseDto;
import com.lee1314.raylee.modules.audio.pojo.dto.PeopleDailyDto;
import com.lee1314.raylee.modules.audio.service.PeopleDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("peopleDaily")
public class PeopleDailyController {

    private PeopleDailyService service;

    @Autowired
    public PeopleDailyController(PeopleDailyService service) {
        this.service = service;
    }

    @PostMapping("query")
    public ResponseDto<?> getPeopleDaily(@RequestBody PeopleDailyDto dto) {
        try {
            return ResponseDto.success(service.queryPeopleDaily(dto.getSeminarId(), dto.getId()));
        } catch (Exception e) {
            return ResponseDto.error("系统异常，请稍后再试!");
        }
    }
}
