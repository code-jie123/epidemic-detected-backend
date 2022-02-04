package com.example.backendmysql.util;

public class Result<T> {
    private int code;//状态码
    private String message;//状态信息描述
    private T data;//数据信息

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> Result<T> success(int code,String message){
        return new Result<T>(code,message);
    }
    public static <T> Result<T> success(int code,String message,T data){
        return new Result<T>(code,message,data);
    }

    public static <T> Result<T> error(int code,String message,T data){
        return new Result<T>(code,message,data);
    }
    public static <T> Result<T> error(int code,String message){
        return new Result<T>(code,message);
    }
}
