package com.lssl.medical.bean;

import lombok.Data;

/**
 * @author : 黑渊白花
 * @ClassName Result
 * @date : 2024/9/23 16:23
 * @Description
 */
@Data
public class Result {
    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "404";

    /*状态码*/
    private String code;
    /*响应数据*/
    private Object data;
    /*响应数据*/
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

    public static Result success(Object data,String msg){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }


    public static Result error( String msg){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }


}
