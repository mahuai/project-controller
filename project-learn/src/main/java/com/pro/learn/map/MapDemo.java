package com.pro.learn.map;

import java.util.*;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.map
 * @date: Created in 2018/9/6  10:08
 */
public class MapDemo {

    public static void main(String[] args) {
        Map<String, Object> hashMap = new HashMap<String, Object>(5);
        hashMap.put("", "");

        Map<String, Object> hashtable = new Hashtable<String, Object>(5);

        Map<String, Object> map = new TreeMap<String, Object>(hashMap);

        System.out.println();

        int n = 11;
        n-=1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n |= n >>> 1);
        System.out.println(n |= n >>> 2);
        System.out.println(n |= n >>> 4);
        System.out.println(n |= n >>> 8);
        System.out.println(n |= n >>> 16);

        System.out.println((n < 0) ? 1 : (n >= 30) ? 30 : n + 1);
    }
}
