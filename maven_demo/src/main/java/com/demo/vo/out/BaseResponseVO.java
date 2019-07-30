package com.demo.vo.out;

import java.io.Serializable;

public class BaseResponseVO<T> implements Serializable{

    private String code;

    private String desc;

    private T data;

    public BaseResponseVO(String code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
