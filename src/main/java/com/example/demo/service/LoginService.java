package com.example.demo.service;

import com.example.demo.dto.Login;

public interface LoginService {

    Login login(Login login);
    Login getMallLogin(int id);
}
