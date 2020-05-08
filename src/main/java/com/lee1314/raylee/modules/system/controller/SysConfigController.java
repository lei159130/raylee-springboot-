package com.lee1314.raylee.modules.system.controller;

import com.lee1314.raylee.commons.pojo.dto.ResponseDto;
import com.lee1314.raylee.modules.audio.pojo.dto.PeopleDailyDto;
import com.lee1314.raylee.modules.audio.service.PeopleDailyService;
import com.lee1314.raylee.modules.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sysConfig")
public class SysConfigController {

    @Autowired
    private SysConfigService service;

    @PostMapping("menus")
    public ResponseDto<?> getMenus() {
        try {
            return ResponseDto.success(service.queryMenus());
        } catch (Exception e) {
            return ResponseDto.error("系统异常，请稍后再试!");
        }
    }
}
