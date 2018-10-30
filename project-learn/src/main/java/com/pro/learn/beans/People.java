package com.pro.learn.beans;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.beans
 * @date: Created in 2018/9/27  14:07
 */
public class People {

    public People(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    private String name;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
