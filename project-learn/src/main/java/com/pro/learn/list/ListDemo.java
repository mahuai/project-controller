package com.pro.learn.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.list
 * @date: Created in 2018/9/11  14:40
 */
public class ListDemo {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>(5);
        arrayList.add("a");
        Arrays.asList(arrayList);
        List<String> linkedList = new LinkedList<>();
        linkedList.add("b");

    }
}
