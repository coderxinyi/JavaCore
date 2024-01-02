package com.xinyi.test;

import java.util.Calendar;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2023/12/31 10:18:00
 */
public class TimeDemo {

    public static void main(String[] args) {
        // 获取当前时间
        Calendar calendar = Calendar.getInstance();

        // 设置时间为凌晨三点
        calendar.set(Calendar.HOUR_OF_DAY, 3);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // 输出当前时间的凌晨三点
        System.out.println("当前时间的凌晨三点：" + calendar.getTime());

        // 将日期加一天
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        // 输出下一天凌晨三点
        System.out.println("下一天凌晨三点：" + calendar.getTime());
    }
}
