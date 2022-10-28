package com.xinyi.book.corejavavolume2.chapter01;

import sun.java2d.pipe.SpanIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author xinyi
 * @Date 2022/10/19 下午9:48
 */
public class StreamMap {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("boat");
        // map
        Stream<Stream<String>> streamStream = words.stream().map(w -> codePoints(w));
        // flatMap
        Stream<String> stringStream = words.stream().flatMap(w -> codePoints(w));

    }

    public static Stream<String> codePoints(String s){

        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i,j));
            i = j;
        }
        return result.stream();
    }
}
