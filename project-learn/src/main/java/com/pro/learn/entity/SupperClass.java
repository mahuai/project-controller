package com.pro.learn.entity;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.entity
 * @date: Created in 2018/9/5  15:12
 */
public abstract class SupperClass extends BaseClass {


    public SupperClass(Person person){
        super(person);
        if (person == null) {
            throw new NullPointerException("this person not null");
        }
        System.out.println(person.getName() + "洗漱");
    }
}
