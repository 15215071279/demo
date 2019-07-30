package com.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
* @Description: 签名工具类
* @Author:       tianjun
* @date:         2019/6/28 11:47
*/
public class SignUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(SignUtils.class);

    /**
     * 得到签名
     * @param params 参数集合不含secretkey
     * @param secret 验证接口的secretkey
     * @return
     */
    public static String getSign(Map<String, String> params, String secret)
    {
        String sign="";
        StringBuilder sb = new StringBuilder();
        //step1：先对请求参数排序
        Set<String> keyset=params.keySet();
        TreeSet<String> sortSet=new TreeSet<String>();
        sortSet.addAll(keyset);
        Iterator<String> it=sortSet.iterator();
        //step2：把参数的key value链接起来 secretkey放在最后面，得到要加密的字符串
        while(it.hasNext())
        {
            String key=it.next();
            String value=params.get(key);
            sb.append(key).append(value);
        }
        sb.append(secret);
        byte[] md5Digest;
        try {
            //得到Md5加密得到sign
            md5Digest = getMD5Digest(sb.toString());
            sign = byte2hex(md5Digest);
        } catch (IOException e) {
            LOGGER.error("生成签名错误",e);
        }
        return sign;
    }

    private static byte[] getMD5Digest(String data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data.getBytes("UTF-8"));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse);
        }
        return bytes;
    }


    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
            //sign.append(hex.toLowerCase());
        }
        return sign.toString();
    }

}
