package com.hjc.demo.mybatisplusdemo;

import org.quartz.CalendarIntervalScheduleBuilder;
import org.quartz.CalendarIntervalTrigger;
import org.quartz.Trigger;

import java.util.Date;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author : Administrator
 * @date : 2018/11/12 0012 16:14
 * @description :
 */
public class SchdualQuartz {
    public static void main(String[] args) {
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1") //定义name/group
                .startNow()//一旦加入scheduler，立即生效
                .withSchedule(simpleSchedule() //使用SimpleTrigger
                        .withIntervalInSeconds(1) //每隔一秒执行一次
                        .repeatForever()) //一直执行，奔腾到老不停歇
                .build();
        CalendarIntervalScheduleBuilder calendarIntervalScheduleBuilder = null;
        Trigger trigger1 = newTrigger().startAt(new Date()).withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInDays(50)).build();
        CalendarIntervalTrigger trigger2;
    }
}
