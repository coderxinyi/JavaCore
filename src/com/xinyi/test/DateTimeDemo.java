package com.xinyi.test;

import java.time.LocalDateTime;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2023/10/07 17:47:00
 */
public class DateTimeDemo {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime dateTimeBefore7Days = dateTime.minusDays(7);
        System.out.println(dateTimeBefore7Days);
    }
}

