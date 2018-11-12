package com.hjc.demo.mybatisplusdemo.test.service.Test.impl;

import com.hjc.demo.mybatisplusdemo.test.model.Test.SysUser;
import com.hjc.demo.mybatisplusdemo.test.dao.Test.SysUserMapper;
import com.hjc.demo.mybatisplusdemo.test.service.Test.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author hjc
 * @since 2018-10-28
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
/*
    @Autowired
    private SysUserMapper sysUserMapper;

    @PostConstruct
    public void init() {
        List list = sysUserMapper.selectList(null);
        list.forEach(temp-> System.out.println(temp));
    }*/

}
