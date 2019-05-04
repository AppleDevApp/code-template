package com.codebox.codetemplate.api.common;

import com.codebox.codetemplate.core.exception.CommonException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private Integer code;
    private T data;
    private String message;

    private ApiResponse() {
    }

    private ApiResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    private ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private ApiResponse(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static ApiResponse sucess() {
        return new ApiResponse(10000, null);
    }

    public static <T> ApiResponse<T> sucess(T data) {
        return new ApiResponse<T>(10000, data);
    }

    public static ApiResponse fail(Integer code, String message) {
        return new ApiResponse<>(code, message);
    }

    public static <T> ApiResponse<T> fail(Integer code, T data, String message) {
        return new ApiResponse<>(code, data, message);
    }

    public static ApiResponse fail(String message) {
        return new ApiResponse(50000, message);
    }

    public static <T> ApiResponse<T> fail(CommonException ex) {
        return new ApiResponse<>(ex.getCode(), ex.getMessage());
    }

}
