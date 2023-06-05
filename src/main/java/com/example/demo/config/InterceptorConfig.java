/**
 * @author 12432
 * @date 2023/05/20
 */
package com.example.demo.config;

import com.example.demo.controller.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwt()).addPathPatterns("/**").excludePathPatterns("/mall-login");
    }

    @Bean
    public JwtInterceptor jwt() {
        return new JwtInterceptor();
    }
}
