/**
 * @author 12432
 * @date 2023/05/08
 */
package com.example.demo.controller.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionProcessor {
    @ExceptionHandler(Exception.class)
    public String projectExceptionHandler(Exception exception) {
        exception.printStackTrace();
        System.out.println("项目出现异常!");

        return exception.getMessage();
    }
}
