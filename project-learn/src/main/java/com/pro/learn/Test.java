package com.pro.learn;

import com.base.utils.DateUtils;
import com.pro.learn.beans.ExtendedBeanInfoFactory;
import com.pro.learn.entity.Person;
import com.pro.learn.entity.SubClass;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.MethodDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
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

        /*SubClass subClass = new SubClass(new Person("丽丽", 17, "女"));*/

        System.out.println("-----------------invoking no  parameter constructor");
        ChildClass child = new ChildClass();
        Class childClass = child.getClass();
        Method method1 = childClass.getMethod("noArgumentConstructor");
        method1.invoke(child);
        System.out.println("-----------------invoking int  parameter constructor");

        Method method2 = childClass.getMethod("parameterConstructor", int.class, int.class);
        method2.invoke(child, 10, 20);

        System.out.println("-----------------invoking String  parameter constructor");
        Class<?>[] clazzArray = new Class<?>[2];
        String[] array = new String[]{"30","40"};
        for (int i = 0; i < array.length; i++) {
            String className=array[i].getClass().getName();
            clazzArray[i]=Class.forName(className);
        }
        Method method3 = childClass.getMethod("parameterConstructor", clazzArray);
        method3.invoke(child, array);
    }


    static class ChildClass {

        public void noArgumentConstructor() {
            System.out.println("this is no arguments constructor");
//            System.out.println();
        }

        public void parameterConstructor(int a, int b) {
            System.out.println("this is parameter constructor ,args:" + a + "-----" + b);
//            System.out.println("this is parameter constructor ,constructor:");
        }

        public void parameterConstructor(String a, String b) {
            System.out.println("this is parameter constructor ,args:" + a + "-----" + b);
//            System.out.println("this is parameter constructor ,constructor:");
        }
    }

}
