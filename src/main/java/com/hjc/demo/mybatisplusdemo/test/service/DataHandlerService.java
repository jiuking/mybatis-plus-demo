package com.hjc.demo.mybatisplusdemo.test.service;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 后端查询数据处理类
 */
public class DataHandlerService {

    //1，处理数据查询去重
    public static List handlerMultiple(List list){
        return ImmutableSet.copyOf(list).asList();
    }

    public static void main(String[] args) {
        List<Tset> lists = new ArrayList<>();
        Tset t1 = new Tset();
        t1.setName("张三");
        Tset t2 = new Tset();
        t2.setName("李四");
        Tset t3 = new Tset();
        t3.setName("张三");
        lists.add(t1);
        lists.add(t2);
        lists.add(t3);
        for (Tset list : lists) {
            System.out.println(list.getName());
        }
        lists = handlerMultiple(lists);
        System.out.println("-----");
        for (Tset list : lists) {
            System.out.println(list.getName());
        }

    }
    //2，
}

class Tset{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
