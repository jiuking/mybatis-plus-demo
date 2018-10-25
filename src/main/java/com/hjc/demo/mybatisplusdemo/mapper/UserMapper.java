package com.hjc.demo.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjc.demo.mybatisplusdemo.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author : Administrator
 * @date : 2018/10/25 0025 17:29
 * @description :
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where id =1")
    User getUser();
}
