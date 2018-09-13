package com.pro.learn;

import com.base.utils.DateUtils;
import com.pro.learn.beans.ExtendedBeanInfoFactory;
import com.pro.learn.entity.Person;
import com.pro.learn.entity.SubClass;

import java.beans.BeanInfo;
import java.beans.MethodDescriptor;
import java.lang.reflect.Method;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn
 * @date: Created in 2018/9/5  15:15
 */
public class Test {

    private String name;

    public void test() {
        System.out.println("this is test method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {

        SubClass subClass = new SubClass(new Person("丽丽", 17, "女"));

        System.out.println(DateUtils.time2Date(System.currentTimeMillis()));

        ExtendedBeanInfoFactory beanInfoFactory = new ExtendedBeanInfoFactory();
        BeanInfo beanInfo = beanInfoFactory.getBeanInfo(Test.class);
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        for (int i = 0; i < methodDescriptors.length; i++) {
            Method method = methodDescriptors[i].getMethod();
            System.out.println(method.getName());
        }
    }


    public Test() {
        System.out.println("无参构造函数");
    }

    public Test(String name) {
        this.name = name;
        System.out.println("有参构造函数");
    }
}
