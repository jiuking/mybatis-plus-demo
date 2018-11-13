package com.hjc.demo.mybatisplusdemo;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.Objects;

public class FastJsonNullFilter implements ValueFilter {
    @Override
    public Object process(Object o, String s, Object o1) {
        if (Objects.isNull(o1)) {
            return "-";
        }
        return o1;
    }
}
