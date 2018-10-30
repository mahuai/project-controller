package com.pro.learn.enumeration;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.enumeration
 * @date: Created in 2018/9/30  14:23
 */
public enum Conditions {

    /**
     * 企业
     */
    COMPANY("1", "企业"),
    /**
     * 个人
     */
    PERSONAGE("2", "个人"),

    /**
     * 测试
     */
    TEST("3", "其他");


    private String code;

    private String value;

    Conditions(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
