package com.hjc.demo.mybatisplusdemo.test.dao.Test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hjc.demo.mybatisplusdemo.test.model.Test.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

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

    List<SysUser> selectById11();

    Set<SysUser> selectByWrapper(@Param(Constants.WRAPPER)Wrapper<?> tWrapper);
}
