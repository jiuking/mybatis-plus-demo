package com.hjc.demo.mybatisplusdemo;

import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Administrator
 * @date : 2018/11/12 0012 12:39
 * @description :
 */
public class TestCopy {
    public static void main(String[] args) {
        Test11 test1 = new Test11();
        Test11 test2 = new Test11();
        test1.setA("a1");
        test1.setB(1f);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
//        System.out.println(sdf.format(date));
        test1.setDate(date);
        test2.setA("a2");
        test2.setB(2f);
        BeanUtils.copyProperties(test1, test2);
        System.out.println(test2.getDate());
        System.out.println(test2.getDate());
    }

}

class Test11 {
    private String a;
    private Float b;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Float getB() {
        return b;
    }

    public void setB(Float b) {
        this.b = b;
    }
}