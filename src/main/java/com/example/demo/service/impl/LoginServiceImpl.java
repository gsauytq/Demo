/**
 * @author 12432
 * @date 2023/05/19
 */
package com.example.demo.service.impl;

import com.example.demo.dao.LoginDAO;
import com.example.demo.dto.Login;
import com.example.demo.pojo.LoginList;
import com.example.demo.service.LoginService;
import com.example.demo.util.TokenUtils;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginDAO loginDAO;

    public LoginServiceImpl(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public Login login(Login mallLogin) {
        LoginList login = loginDAO.login(mallLogin);
        if (login != null) {
            Login loginDto = new Login(login.getId(), login.getAdmin(), login.getPassword(), login.getAuthority());
            switch (loginDto.getAuthority()) {
                case 1: {
                    loginDto.setAuthorityInfo("系统管理员");
                    break;
                }
                case 2: {
                    loginDto.setAuthorityInfo("商城管理员");
                    break;
                }
                case 3: {
                    loginDto.setAuthorityInfo("店铺管理员");
                    break;
                }
                default: {
                    System.out.println("权限响应错误！");
                }
            }
            String token = TokenUtils.getToken(loginDto.getId().toString(), loginDto.getPassword());
            loginDto.setToken(token);
            return loginDto;
        }

        return null;
    }

    @Override
    public Login getMallLogin(int id) {
        Login login = loginDAO.selectById(id);
        return login;
    }
}
