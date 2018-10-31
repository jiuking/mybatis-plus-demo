package com.hjc.demo.mybatisplusdemo;

import java.util.UUID;

public class UUIDUtils {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            //注意replaceAll前面的是正则表达式
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            System.out.println(uuid);
//            System.out.println(uuid.length());
        }
    }
}
