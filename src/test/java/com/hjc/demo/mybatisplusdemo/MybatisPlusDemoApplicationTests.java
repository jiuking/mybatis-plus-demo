package com.hjc.demo.mybatisplusdemo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Condition;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hjc.demo.mybatisplusdemo.entity.User;
import com.hjc.demo.mybatisplusdemo.mapper.UserMapper;
import com.hjc.demo.mybatisplusdemo.test.dao.Test.SysUserMapper;
import com.hjc.demo.mybatisplusdemo.test.model.Test.SysUser;
import com.hjc.demo.mybatisplusdemo.test.service.FileService;
import com.hjc.demo.mybatisplusdemo.test.service.Test.ISysUserService;
import com.hjc.demo.mybatisplusdemo.test.service.Test.impl.SysUserServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
//        System.out.println(userMapper.getUser().getName());
    }

    @Test
    public void tet() {
        String a = sysUserMapper.getSqlTable();
        System.out.println(sysUserMapper.getBySql(a));
    }

    @Autowired
    private FileService fileService;
    @Test
    public void tes() throws InterruptedException {
        test1(3);
        new Thread(()->{
            try {
                test1(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        test1(4);
    }

    public void test1(int i) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        CountDownLatch countDownLatch = new CountDownLatch(2);
        fileService.testthread1(countDownLatch,i);
        fileService.testthread2(countDownLatch,i);

        countDownLatch.await();

        System.out.println("等待是最美的"+i);
    }

    @Autowired
    private ServiceImpl sysUserService;

    @Test
    public void testBatch() {
//        sysUserMapper.
        List<SysUser> list = new ArrayList<>();
        SysUser sysUser = new SysUser();
        sysUser.setId(1234);
        sysUser.setName("asdf111");
        list.add(sysUser);
        sysUserService.saveOrUpdateBatch(list);

        System.out.println(sysUserMapper.selectById11());
    }

    @Test
    public void testUpdate() {
        SysUser sysUser = new SysUser();
        sysUser.setId(1234);
        sysUser.setName("assd1");
        sysUserMapper.updateById(sysUser);
        sysUserMapper.update(sysUser, new UpdateWrapper<>(sysUser));
        sysUserMapper.deleteById(1234);
    }

    @Test
    public void testWrapper() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", "asdf111");
//        Set<SysUser> list = sysUserMapper.selectByWrapper(queryWrapper);
//        list.forEach(temp -> System.out.println(temp.getName()));
    }

    @Test
    public void testSqlWrapper() {
        QueryWrapper queryWrapper = Condition.create().select(" SELECT * FROM sys_user");
//        queryWrapper.eq("name", "asdf11");
        Set<SysUser> list = sysUserMapper.selectByWrapper(queryWrapper);
        list.forEach(temp -> System.out.println(temp.getName()));
    }
}
