package com.demo.utils;

/**
* @Description: 字符串工具类
* @Author:       tianjun
* @date:         2019/6/28 10:58
*/
public class StringUtils {

    /**
    * 判断所有字符串是否为空
    * @author      tianjun
    * @date        2019/6/28 10:58
    * @param
    * @return      都不为空返回true
     */
    public static boolean allNotBlank(String... args){
        boolean flag = true;
        for(String arg : args){
            if(arg == null || "".equals(arg)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
    * 判断字符串是否为空
    * @author      tianjun
    * @date        2019/6/28 11:14
    * @param       str
    * @return      字符串为空时返回true
     */
    public static boolean isNotBlank(String str){
        if(str==null || "".equals(str)){
            return false;
        }
        return true;
    }

}
