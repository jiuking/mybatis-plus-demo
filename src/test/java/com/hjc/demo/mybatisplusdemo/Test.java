package com.hjc.demo.mybatisplusdemo;

import com.google.common.base.Objects;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * @version V1.0  by 石冬冬-Heil Hitler on  2017/4/7 13:08
 */
public class Test {
    /**
     * Description: 并集<br>
     * @version V1.0 2017/4/7 13:09  by 石冬冬-Heil Hilter（dd.shi02@zuche.com)
     * @return
     */
    public static void union(){
        List<String> list1 = new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
        }};
        List<String> list2 = new ArrayList<String>(){{
            add("C");
            add("D");
            add("B");
        }};
        //求出并集
        list1.addAll(list2);
        System.out.println(list1);
    }

    /**
     * Description: 交集<br>
     * @version V1.0 2017/4/7 13:09  by 石冬冬-Heil Hilter（dd.shi02@zuche.com)
     * @return
     */
    public static void intersection(){
        List<String> list1 = new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
        }};
        List<String> list2 = new ArrayList<String>(){{
            add("C");
            add("D");
            add("B");
        }};
        //求出交集
        list1.retainAll(list2);
        System.out.println(list1);
    }

    /**
     * Description: 差集<br>
     * @version V1.0 2017/4/7 13:09  by 石冬冬-Heil Hilter（dd.shi02@zuche.com)
     * @return
     */
    public static void diff(){
        List<String> list1 = new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
        }};
        List<String> list2 = new ArrayList<String>(){{
            add("C");
            add("D");
            add("B");
        }};
        //求出差集
        list1.removeAll(list2);
        System.out.println(list1);
    }
    /**
     * Description: 对象集合的交集<br>
     * @version V1.0 2017/4/7 13:21  by 石冬冬-Heil Hilter（dd.shi02@zuche.com)
     * @param null
     * @return
     */
    public static void test(){
        List<Student> list1 = new ArrayList<Student>(){{
            add(new Student("Linda1",20,"男","1"));
            add(new Student("Bruce1",20,"女",""));
            add(new Student("Linda",21,"",""));
        }};
        List<Student> list2 = new ArrayList<Student>(){{
            add(new Student("Linda",21,"女",""));
            add(new Student("Bruce",20,"女",""));
            add(new Student("Jack",21,"",""));
        }};
        //求出交集
        list1.retainAll(list2);
        System.out.println(list1);
    }

    public static void main(String[] args) {
//        union();
//        intersection();+
//        diff();
//        test();
        System.out.println(null == null);
        System.out.println(Objects.equal(null,null));

        System.out.println("asdf4".length() > 4?"asdf4".substring(0,4):"s");
    }
    /**
     * Description: 内部学生类<br>
     * @version V1.0 2017/4/7 13:20  by 石冬冬-Heil Hilter（dd.shi02@zuche.com)
     * @param null
     * @return
     */
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
            if(obj instanceof Student){
                Student other = (Student)obj;
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