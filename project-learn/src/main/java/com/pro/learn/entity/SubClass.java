package com.pro.learn.entity;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.entity
 * @date: Created in 2018/9/5  15:12
 */
public class SubClass extends SupperClass {


    public SubClass(Person person) {
        super(person);
        if (person == null) {
            throw new NullPointerException("this person not null");
        }
        System.out.println(person.getName() + "吃饭");
    }


}
