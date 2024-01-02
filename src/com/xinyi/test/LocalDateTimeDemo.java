package com.xinyi.test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2023/12/26 14:24:00
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime beginTime = now.with(TemporalAdjusters.firstDayOfMonth()).withHour(00).withMinute(00).withSecond(00).withNano(0);
        LocalDateTime endTime = now.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59).withNano(0);

        System.out.println(beginTime);
        System.out.println(endTime);

        String str = "adsd";
        String[] split = str.split(",");
        System.out.println(split.length);

        String fileName = System.getProperty("user.dir") + File.separator + "`学员背词数据统计`" + ".xlsx";

        System.out.println("fileName " + fileName);
    }
}
