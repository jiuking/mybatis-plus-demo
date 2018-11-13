package com.hjc.demo.mybatisplusdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import netscape.javascript.JSObject;

public class FastJsonTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge("asfd");
        System.out.println(JSON.toJSONString(person,new FastJsonNullFilter()));
    }
}
@Data
class Person{
    @JSONField(serialzeFeatures = SerializerFeature.WriteNullStringAsEmpty)
    private String name;
    private String age;
}
