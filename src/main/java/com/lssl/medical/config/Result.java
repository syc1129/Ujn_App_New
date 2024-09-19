package com.lssl.medical.config;

import lombok.Data;

@Data
public class Result {
    //这个类用于统一结果的包装

    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "404";

    private String code;
    private Object data;
    private String msg;
    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    public static Result error( String msg){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }
    public static Result error( String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
