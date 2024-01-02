package com.xinyi.test;


import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author guxinxin
 * @version 1.0.0
 * @Description TODO
 * @createTime 2023年03月23日 09:47:00
 */
public class SplitDemo {

    public static void main(String[] args) {
        String str = "(VIP6YV24076)(VIP6JZYV24076)";
        String[] classCodeArray = str.replace("\\(", "").replace("(","")
                                     .split("\\)");
        List<String> strings = Arrays.asList(classCodeArray);
        System.out.println(strings);

    }


}
