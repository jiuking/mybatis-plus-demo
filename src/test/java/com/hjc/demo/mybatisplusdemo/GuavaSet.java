package com.hjc.demo.mybatisplusdemo;

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
            add(new Test.Student("Linda1",20,"男","1"));
            add(new Test.Student("Bruce1",20,"女",""));
            add(new Test.Student("Linda",21,"",""));
        }};
        List<Test.Student> list2 = new ArrayList<Test.Student>(){{
            add(new Test.Student("Linda",21,"女",""));
            add(new Test.Student("Bruce",20,"女",""));
            add(new Test.Student("Jack",21,"",""));
        }};

        List<String> list = new ArrayList<>();
//        list.retainAll(list)  取出存在的id，设置到新的对象中。
        list1.stream().filter(temp -> list2.contains(temp)).collect(Collectors.toList());

        Sets.difference(new HashSet<>(), new HashSet<>());
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
