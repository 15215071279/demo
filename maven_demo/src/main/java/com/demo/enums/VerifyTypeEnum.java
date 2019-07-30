package com.demo.enums;

/**
* @Description: 验证码类型枚举
* @Author:       tianjun
* @date:         2019/6/28 11:28
*/
public enum VerifyTypeEnum {
    VERIFY_REGISTER_ONE("1", "register"),
    VERIFY_RESETPWD_TWO("2", "resetpwd"),
    VERIFY_BANDCARD_THREE("3", "bankcard"),
    VERIFY_PAYPWD_FOUR("4", "paypwd"),
    VERIFY_RESETPAYPWD_FIVE("5", "resetpaypwd"),
    VERIFY_LOAN_SIX("6", "smslogin"),
    CYC_REGISTER_ONE("7", "cycrgister");

    private VerifyTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getValue(String acflag) {
        for(VerifyTypeEnum verifyTypeEnum : VerifyTypeEnum.values()){
            if(verifyTypeEnum.getCode().equals(acflag)){
                return verifyTypeEnum.getMsg();
            }
        }
        return "";
    }

}
