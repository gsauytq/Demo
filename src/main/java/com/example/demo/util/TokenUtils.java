/**
 * @author 12432
 * @date 2023/05/20
 */
package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenUtils {
    public static String getToken(String userId, String sign) {
        return JWT.create().withAudience(userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
                .sign(Algorithm.HMAC256(sign));
    }
}
