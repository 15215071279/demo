package com.demo.boot.conf.shiro.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm {

    @Override
    public String getName() {
        return "a"; //realm name 为 “a”
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return true;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyRealm1");
        return new SimpleAuthenticationInfo(
                "zhang1", //身份 字符串类型
                "123",   //凭据
                getName() //Realm Name
        );
    }



}
