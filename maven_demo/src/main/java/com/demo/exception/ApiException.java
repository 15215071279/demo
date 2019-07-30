package com.demo.exception;

/**
* @Description:  API异常
* @Author:       tianjun
* @date:         2019/6/28 11:09
*/
public class ApiException extends RuntimeException {

    private String code;
    private String desc;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ApiException(String code, String desc) {
        super("ApiException:code=" + code + "," + desc);
        this.code = code;
        this.desc = desc;
    }

    public String toString() {
        return "ApiException{code='" + this.code + '\'' + ", desc='" + this.desc + '\'' + "} " + super.toString();
    }

}
