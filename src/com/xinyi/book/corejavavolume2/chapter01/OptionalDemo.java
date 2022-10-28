package com.xinyi.book.corejavavolume2.chapter01;


import java.util.Optional;

/**
 * @Author xinyi
 * @Date 2022/10/19 下午10:09
 */
public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> optionalS = Optional.empty();

        String s = optionalS.orElse("你好");
        System.out.println(s);
        String x = optionalS.orElseGet(() -> System.getProperty("x"));
        System.out.println(x);

        Optional<String> optionalS1 = Optional.ofNullable("");
        String s1 = optionalS1.get();
        System.out.println(s1);


    }
}
