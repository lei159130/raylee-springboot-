package com.lee1314.raylee.modules.auth.service;

public interface AuthService {
    boolean checkPwd(String password);

    boolean checkToken(String token);
}
