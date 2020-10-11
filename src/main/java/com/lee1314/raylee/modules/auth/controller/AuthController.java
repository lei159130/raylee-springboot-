package com.lee1314.raylee.modules.auth.controller;

import com.lee1314.raylee.commons.pojo.dto.ResponseDto;
import com.lee1314.raylee.commons.utils.CacheUtils;
import com.lee1314.raylee.modules.auth.pojo.dto.AuthDto;
import com.lee1314.raylee.modules.auth.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private AuthService service;

    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("login")
    public ResponseDto<?> login(@RequestBody AuthDto dto) {
        if (StringUtils.isEmpty(dto.getPassword())) {
            return ResponseDto.error("密码不能为空");
        }
        if (service.checkPwd(dto.getPassword())) {
            String token = DigestUtils.md5DigestAsHex((dto.getPassword() + System.currentTimeMillis()).getBytes());
            CacheUtils.put(token, "");
            return ResponseDto.success(token);
        } else {
            return ResponseDto.error("密码错误");
        }
    }

    @PostMapping("check")
    public ResponseDto<?> check(@RequestBody AuthDto dto) {
        if (StringUtils.isEmpty(dto.getToken())) {
            return ResponseDto.error("token不能为空");
        }
        if (service.checkToken(dto.getToken())) {
            return ResponseDto.success();
        } else {
            return ResponseDto.error("token校验失败");
        }
    }
}
