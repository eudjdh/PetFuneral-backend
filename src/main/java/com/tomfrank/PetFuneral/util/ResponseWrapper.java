package com.tomfrank.PetFuneral.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一 API 返回包装
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ResponseWrapper<T> ok() {
        return new ResponseWrapper<>(200, "success", null);
    }

    public static <T> ResponseWrapper<T> ok(T data) {
        return new ResponseWrapper<>(200, "success", data);
    }

    public static <T> ResponseWrapper<T> error(int code, String message) {
        return new ResponseWrapper<>(code, message, null);
    }

    public static <T> ResponseWrapper<T> error(String message) {
        return new ResponseWrapper<>(500, message, null);
    }
}
