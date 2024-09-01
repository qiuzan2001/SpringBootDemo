package com.demo.springboot_demo.exception;

import com.demo.springboot_demo.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //统一处理
public class GlobalExceptionHandlerAdvice {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler(value = Exception.class) //任何异常的父类都是Exception，做异常的统一处理
    public ResponseMessage handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {

        //记录日志
        log.error("统一异常：",e);
                        //无论后台出现什么异常，前段统一返回code500，表示后端异常
                        //至于是什么类型的异常，可以查询日志
        return new ResponseMessage(500,"error",null);
    }
}
