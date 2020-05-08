package com.lee1314.raylee.commons.pojo.dto;

public class ResponseDto<T> {
    private String code;
    private String msg;
    private T data;

    private ResponseDto(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseDto<T> success() {
        return success(null);
    }

    public static <T> ResponseDto<T> success(T data) {
        return success("成功", data);
    }

    public static <T> ResponseDto<T> success(String msg, T data) {
        return success("0", msg, data);
    }

    public static <T> ResponseDto<T> success(String code, String msg, T data) {
        return new ResponseDto<T>(code, msg, data);
    }

    public static <T> ResponseDto<T> error(String msg) {
        return error("-1", msg);
    }

    public static <T> ResponseDto<T> error(String code, String msg) {
        return error(code, msg, null);
    }

    public static <T> ResponseDto<T> error(String code, String msg, T data) {
        return new ResponseDto<T>(code, msg, data);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
