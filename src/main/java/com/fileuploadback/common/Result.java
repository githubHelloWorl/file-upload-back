package com.fileuploadback.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    private static final Integer code_ok = 1;
    private static final String msg_success = "操作成功";
    private static final String msg_error = "操作失败";


    // 增删改 成功
    public static <T> Result<T> success(){
        return new Result<>(1,"success",null);
    }

    // 查询 成功
    public static <T> Result<T> success(Integer code,T data){
        return new Result<>(code,"success",data);
    }

    // 四项全部失败
    public static <T> Result<T> error(Integer code,String msg,T data){
        return new Result<>(code,msg,data);
    }
}
