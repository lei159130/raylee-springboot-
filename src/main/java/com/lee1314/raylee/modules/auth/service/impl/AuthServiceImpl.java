package com.lee1314.raylee.modules.auth.service.impl;

import com.lee1314.raylee.commons.utils.CacheUtils;
import com.lee1314.raylee.modules.auth.service.AuthService;
import com.lee1314.raylee.modules.system.pojo.entity.SysConfig;
import com.lee1314.raylee.modules.system.service.SysConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AuthServiceImpl implements AuthService {

    private SysConfigService service;

    @Autowired
    public AuthServiceImpl(SysConfigService service) {
        this.service = service;
    }

    @Override
    public boolean checkPwd(String password) {
        if (StringUtils.isEmpty(password)) {
            return false;
        }
        SysConfig config = service.queryByBusinessAndCode("auth", "password");
        if (config == null) {
            return false;
        }
        if (!config.getContent().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkToken(String token) {
        if (CacheUtils.containsKey(token)) {
            CacheUtils.put(token, "");
            return true;
        }
        return false;
    }
}
