package com.demo.enums;

import java.util.ArrayList;
import java.util.List;

/**
* @Description: 接口返回码枚举
* @Author:       tianjun
* @date:         2019/6/28 11:01
*/
public enum ResponseCodeEnum {

    /**
     * 请求成功
     */
    SUCCESS("0000", "success"),

    /**
     * 请求失败
     */
    FAIL("0001", "fail"),

    //---------------网络请求异常：1开头----------------

    /**
     * 无效请求（400）
     */
    INVALID_REQUEST("1001","invalid request"),

    /**
     * 无效的url（404）
     */
    INVALID_URL("1002", "invalid url"),

    /**
     * 禁止访问（405）
     */
    METHOD_NOT_ALLOWED("1003", "method not allowed"),

    /**
     * 无法接受（406）
     */
    UNACCEPTABLE_REQUEST("1004", "unacceptable request"),

    /**
     * 不支持的媒体类型（415）
     */
    UNSUPPORTED_MEDIA_TYPE("1005", "unsupported media type"),

    /**
     * 内部错误(500)
     */
    INTERNAL_ERROR("1005","internal error"),

    /**
     * 服务不可用（503）
     */
    INVALID_SERVER("1006","unavailable server"),


    //-----------------系统异常：2开头-------------------

    /**
     * 参数错误
     */
    ERROR_PARAM("2001", "error parameter"),

    /**
     * 接入拒绝
     */
    ACCESS_REJECT("2010", "access reject"),

    /**
     * 非法的app_id
     */
    ILLEGAL_APP_KEY("2011", "illegal app_key"),

    /**
     * 无效的签名
     */
    INVALID_SIGNATURE("2012", "valid signature");


    /**
     * 构造一个<code>CodeEnum</code>枚举对象
     *
     * @param code
     * @param message
     */
    private ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 枚举值
     */
    private final String code;
    /**
     * 枚举描述
     */
    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return ResponseCodeEnum
     */
    public static ResponseCodeEnum getByCode(Integer code) {
        for (ResponseCodeEnum _enum : values()) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ResponseCodeEnum>
     */
    public static List<ResponseCodeEnum> getAllEnum() {
        List<ResponseCodeEnum> list = new ArrayList();
        for (ResponseCodeEnum _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public static List<String> getAllEnumCode() {
        List<String> list = new ArrayList();
        for (ResponseCodeEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }


}
