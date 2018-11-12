package com.hjc.demo.mybatisplusdemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author : Administrator
 * @date : 2018/11/12 0012 16:14
 * @description :
 */
public class SchdualQuartz {
    public static void main(String[] args) throws SchedulerException {
        //创建scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Trigger trigger1 = newTrigger().startAt(new Date()).withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInSeconds(50)).build();

        //定义一个JobDetail
        JobDetail job = newJob(HelloQuartz.class) //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
                .withIdentity("job1", "group1") //定义name/group
                .usingJobData("name", "quartz") //定义属性
                .build();

        //加入这个调度
        scheduler.scheduleJob(job, trigger1);

        //启动之
        scheduler.start();
    }
}
