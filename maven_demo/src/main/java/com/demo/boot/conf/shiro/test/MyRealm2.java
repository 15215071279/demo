package com.demo.boot.conf.shiro.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.Realm;

public class MyRealm2 implements Realm {

    @Override
    public String getName() {
        return "b"; //realm name 为 “b”
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return true;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyRealm2");
        String s = token.getPrincipal().toString();
        if(s.equals("zhang")){
            throw new AuthenticationException("自定义异常");
        }
        return new SimpleAuthenticationInfo(
                "zhang", //身份 字符串类型
                "123",   //凭据
                getName() //Realm Name
        );
    }



}
