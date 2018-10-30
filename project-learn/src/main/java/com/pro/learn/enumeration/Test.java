package com.pro.learn.enumeration;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.enumeration
 * @date: Created in 2018/9/30  14:25
 */
public class Test {

    public static void main(String[] args) {
        getConditions(Conditions.TEST);
    }


    public static void getConditions(Conditions conditions) {

        switch (conditions) {
            case COMPANY:
                System.out.println("企业");
                break;
            case PERSONAGE:
                System.out.println("个人");
                break;
            default:
                System.out.println("其他");
                break;
        }

    }
}
