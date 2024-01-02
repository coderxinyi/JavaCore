package com.xinyi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2023/12/12 11:04:00
 */
public class MatcherDemo {

    public static void main(String[] args) {
        String input = "(VIP6YV24146)(VIP6YV24141)";

        List<String> resultList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }

        System.out.println(resultList);
    }
}
