package com.hjc.demo.mybatisplusdemo.test.dao.Test;

import com.hjc.demo.mybatisplusdemo.test.model.Test.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author hjc
 * @since 2018-10-28
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

//    @Select("select t1.sql from sqlTable t1 where id = '1'")
    String getSqlTable();

//    @Select("SELECT *  FROM (${value}) obj")
    String getBySql(String value);

}
