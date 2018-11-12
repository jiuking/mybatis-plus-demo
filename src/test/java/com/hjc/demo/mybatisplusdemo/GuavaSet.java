package com.hjc.demo.mybatisplusdemo;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GuavaSet {
    public static void main(String[] args) {
        List<Test.Student> list1 = new ArrayList<Test.Student>(){{
            add(new Test.Student("Linda",20,"男","1"));
            add(new Test.Student("Bruce1",20,"女",""));
            add(new Test.Student("Linda",21,"男",""));
        }};
        List<Test.Student> list2 = new ArrayList<Test.Student>(){{
            add(new Test.Student("Linda1",21,"女",""));
            add(new Test.Student("Bruce",20,"女",""));
            add(new Test.Student("Jack",21,"",""));
        }};

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("sadf");
//        list.retainAll(list)  取出存在的id，设置到新的对象中。
        list1.stream().filter(temp -> list2.contains(temp)).collect(Collectors.toList());

        //更新存在的id，
        list1 = Lists.transform(list1,(input)->{
            list2.forEach(temp ->{
                if (temp.equals(input)) {
                    input.setAge(temp.getAge());
                    System.out.println("相等");
                }
            });
            System.out.println(input);
            return input;
        });

        System.out.println(list1);

        Sets.difference(new HashSet<>(), new HashSet<>());
        for (int i = 0; i <3 ; i++) {

            list.forEach(tem -> {
                if (tem.equals("a")) {
                    return;
                }
                System.out.println(tem);
            });
            System.out.print(i);
        }
        List<String> list4 = new ArrayList<>();
//        String[] a = list.toArray(new String[list.size()]);
        String[] a = list4.stream().toArray(String[]::new);
        System.out.println("====");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        Set<Integer> set1=Sets.newHashSet(1,2,3,4,5,6);
        Set<Integer> set2=Sets.newHashSet(3,4,5,6,7,8,9);

        //set 转换list
        List list3 = new ArrayList(set1);
        list3.forEach(System.out::println);

        System.out.println("交集为：");//7,8,9
        Set<Integer>S=Sets.difference(set2, set1);
        for(Integer temp:S) {
            System.out.println(temp);
        }
    }

    public static class Student{
        private String name;
        private int age;
        private String sex;

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        private String height;

        public Student(String name, int age,String sex,String height) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            return (this.getName() + String.valueOf(this.getAge())).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(null == obj)
                return false;
            if(obj instanceof Test.Student){
                Test.Student other = (Test.Student)obj;
                return this.getName().equals(other.getName()) || (this.getAge() == other.getAge()&&this.sex.equals(other.getSex()));
            }
            return false;
        }

        @Override
        public String toString() {
            return MessageFormat.format("[name:{0},age:{1}]",this.getName(),this.getAge());
        }
    }
}
