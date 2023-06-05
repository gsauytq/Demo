/**
 * @author 12432
 * @date 2023/05/20
 */
package com.example.demo.controller.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.dto.Login;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");

        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        if (token == null) {
            throw new RuntimeException("无token，请重新登录");
        }

        Integer id;
        try {
            id = Integer.valueOf(JWT.decode(token).getAudience().get(0));
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }

        Login admin = loginService.getMallLogin(id);
        admin.setToken(token);
        if (admin == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(admin.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("401");
        }
        return true;
    }
}
