package com.hjc.demo.mybatisplusdemo;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Collectors;

public class Test1a {
    public static void main(String[] args) {
        System.out.println("sdf");
        String s = "123|in|233";
        String sql = "select * from tset where id in ('12','34','56')";
        String  result = Splitter.on("|in|").splitToList(s).stream().map(t -> "'".concat(t).concat("'")).reduce((s3, s2) -> s3.concat(",").concat(s2)).get();//.collect(Collectors.toList());

//        String s1 = Joiner.on(",").join(result);
        System.out.println(result);
    }
    public <T> void test(T t) {
        
    }
}
