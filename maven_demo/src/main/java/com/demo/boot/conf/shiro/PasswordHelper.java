package com.demo.boot.conf.shiro;

import com.demo.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
* @Description:  密码处理器
* @Author:       tianjun
* @date:         2019/7/26 9:51
*/
public class PasswordHelper {
    //随机数生成器
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //Hash算法方式
    private String algorithmName = "md5";
    //加密迭代次数
    private final int hashIterations = 2;

    /**
    * 用户密码加密、用户密码盐值设置
    * @author      tianjun
    * @date        2019/7/26 10:03
    * @param
    * @return
     */
    /*public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),//user.getCredentialsSalt() 辅助方法返回 username+salt
                hashIterations).toHex();
        user.setPassword(newPassword);
    }*/
}
