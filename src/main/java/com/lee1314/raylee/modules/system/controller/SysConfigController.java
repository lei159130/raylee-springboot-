package com.lee1314.raylee.modules.system.controller;

import com.alibaba.fastjson.JSON;
import com.lee1314.raylee.commons.pojo.dto.ResponseDto;
import com.lee1314.raylee.modules.system.entity.SysConfig;
import com.lee1314.raylee.modules.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author leili
 */
@RestController
@RequestMapping("sysConfig")
public class SysConfigController {

    private SysConfigService service;

    @Autowired
    public SysConfigController(SysConfigService service) {
        this.service = service;
    }

    @PostMapping("menus")
    public ResponseDto<?> getMenus() {
        try {
            SysConfig config = service.queryByBusinessAndCode("peopledaily", "paramvalue");
            if (config != null) {
                return ResponseDto.success(JSON.parseArray(config.getContent()));
            } else {
                return ResponseDto.success(Collections.emptyList());
            }
        } catch (Exception e) {
            return ResponseDto.error("系统异常，请稍后再试!");
        }
    }
}
