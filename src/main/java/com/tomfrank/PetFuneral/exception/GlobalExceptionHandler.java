package com.tomfrank.PetFuneral.exception;

import com.tomfrank.PetFuneral.util.ResponseWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseWrapper<Void> handleBusinessException(BusinessException e) {
        return ResponseWrapper.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseWrapper<Void> handleException(Exception e) {
        // 未知异常，建议记录日志
        e.printStackTrace();
        return ResponseWrapper.error(500, "服务器异常");
    }
}