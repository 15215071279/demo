package com.demo.bean.sms;

import java.io.Serializable;

/**
* @Description: 短信验证码
* @Author:       tianjun
* @date:         2019/6/28 11:25
*/
public class PhoneVerifyCode implements Serializable {

    private static final long serialVersionUID = 4792787169295931117L;

    private String phone;

    private String code;

    private long createTime;

    private long verifyFailTimes;

    private int verifyType;

    public PhoneVerifyCode() {
    }

    public PhoneVerifyCode(String phone, String code, int verifyType) {
        this.phone = phone;
        this.code = code;
        this.verifyType = verifyType;
        this.createTime = System.currentTimeMillis();
        this.verifyFailTimes = 0L;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getVerifyFailTimes() {
        return verifyFailTimes;
    }

    public void setVerifyFailTimes(long verifyFailTimes) {
        this.verifyFailTimes = verifyFailTimes;
    }

    public int getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(int verifyType) {
        this.verifyType = verifyType;
    }

    @Override
    public String toString() {
        return "PhoneVerifyCode{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", createTime=" + createTime +
                ", verifyFailTimes=" + verifyFailTimes +
                ", verifyType='" + verifyType + '\'' +
                '}';
    }
}
