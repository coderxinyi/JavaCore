package com.xinyi.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2023/10/10 15:20:00
 */
public class Demo7 {

    public static void main(String[] args) {

        String format = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));

        LocalDate month = LocalDate.parse(format + "-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String startMonth = month.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM"));


        String endMonth = month.plusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM"));

        System.out.println(month +  "----" + startMonth + "----" + endMonth);
    }


}
