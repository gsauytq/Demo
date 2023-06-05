/**
 * @author 12432
 * @date 2023/05/19
 */
package com.example.demo.controller;

import com.example.demo.dto.Login;
import com.example.demo.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mall-login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public Login login(@RequestBody Login mallLogin) {
        Login login = loginService.login(mallLogin);
        if (login != null) {
            return login;
        }
        return null;
    }
}
