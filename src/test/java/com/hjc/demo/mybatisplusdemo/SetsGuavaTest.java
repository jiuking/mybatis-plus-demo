package com.hjc.demo.mybatisplusdemo;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * @author : Administrator
 * @date : 2018/11/9 0009 18:34
 * @description :
 */
public class SetsGuavaTest {
    public static void main(String[] args) {
        Set<Integer> sets = Sets.newHashSet(1, 2, 3, 4, 5, 6);
        Set<Integer> sets2 = Sets.newHashSet(3, 4, 5, 6, 7, 8, 9);
        Person p1 = new Person();
        p1.setName("a");

        Person p2 = new Person();
        p2.setName("a");
        Set<Person> people1 = new HashSet<>();
        Set<Person> people2 = new HashSet<>();
        people1.add(p1);
        people1.add(p2);
        people2.add(p1);
        // 交集
        System.out.println("交集为：");
        Sets.SetView<Person> intersection = Sets.union(people1, people2);
        for (Person temp : intersection) {
            System.out.println(temp);
        }

        sets.forEach(System.out::println);
        List<String> list = new ArrayList<>();//Arrays.asList("asdf");
//        Iterables.paddedPartition()
        Iterable<List<String>> iterable = Iterables.partition(list,2);

        iterable.forEach(temp ->{
            System.out.println("====");
            temp.forEach(System.out::println);
            System.out.println("----");
        });
    }


    static class Person{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equal(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
