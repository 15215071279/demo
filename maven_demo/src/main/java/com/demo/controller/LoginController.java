package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.boot.conf.shiro.test.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/login")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/auth")
    public JSONObject authLogin(@RequestBody JSONObject requestJson) {
        String username = requestJson.getString("username");
        String password = requestJson.getString("password");
        JSONObject info = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);

            Object primaryPrincipal1 = currentUser.getPrincipal();
            PrincipalCollection princialCollection = currentUser.getPrincipals();
            Object primaryPrincipal2 = princialCollection.getPrimaryPrincipal();

            Set<String> realmNames = princialCollection.getRealmNames();
            Set<Object> principals = princialCollection.asSet();
            Collection<User> users = princialCollection.fromRealm("c");

            info.put("result", "success");
        } catch(UnknownAccountException e){
            info.put("result", "错误的帐号");
        } catch(IncorrectCredentialsException e){
            info.put("result", "密码错误");
        }catch (AuthenticationException e) {
            logger.error("异常", e);
            info.put("result", "其它异常");
        }
        return info;
    }

    @PostMapping("/testP")
    @RequiresPermissions("user:create")
    public String authLogin() {
        return "测试权限";
    }

}
