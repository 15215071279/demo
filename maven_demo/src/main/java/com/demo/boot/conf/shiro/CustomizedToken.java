package com.demo.boot.conf.shiro;

import org.apache.shiro.authc.*;
/**
* @Description: 定制token
* @Author:       tianjun
* @date:         2019/7/24 19:19
*/
public class CustomizedToken extends  UsernamePasswordToken{
    //登录类型，判断是哪种用户登录
    private String loginType;

    public CustomizedToken(final String username, final String password,String loginType) {
        super(username,password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
