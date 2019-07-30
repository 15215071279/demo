package com.demo.boot.conf.shiro;
/**
* @Description: 登陆类型枚举
* @Author:       tianjun
* @date:         2019/7/24 19:06
*/
public enum LoginTypeEnum {

    CUSTOM("Custom","测试1"),
    SMART("Smart","测试2");

    /**
     * 登陆类型
     */
    private String type;
    /**
     * 登陆类型描述
     */
    private String msg;

    LoginTypeEnum(String type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
