package com.demo.boot.conf.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:  可以把 Realm 看成 DataSource，即安全数据源
* @Author:       tianjun
* @date:         2019/7/23 17:10
*/
public class SysShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("role1");
        authorizationInfo.addRole("role2");

        List<String> permissions = new ArrayList<>();
        permissions.add("user:create");
        permissions.add("user:update");
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
    * 获取身份验证相关信息
     * 密码是怎么验证的
     * authenticationToken 对象中的密码保存的明文
     * AuthenticationInfo 对象中的密码保存的密文，应该从数据库中获取
     * 以上两个对象中的密码， 或根据CredentialsMatcher密码匹配器进行匹配
    * @author      tianjun
    * @date        2019/7/23 17:15
    * @param
    * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();  //得到用户名
        //根据用户名查数据库， 判断用户是否存在
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        //用户如果存在， 取保存到数据库中的加密密码
        String encrptPassword = "a7f1f66653deed94b98a7aeaeca4e19e";

        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, "a7f1f66653deed94b98a7aeaeca4e19e", getName());
        String salt2 = "sssssss";
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username+salt2));
        return authenticationInfo;
    }

    public static void main(String[]args){
        String algorithmName = "md5";
        String username = "zhang";
        String password = "1234";
        String salt1 = username;
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        salt2 = "sssssss";
        int hashIterations = 2;
        String encodedPassword = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations).toString();
        String encodePassword2 = new Md5Hash(password, salt1 + salt2, hashIterations).toString();

        System.out.println(encodedPassword);
        System.out.println(encodePassword2);
    }
}
