package com.xinyi.book.corejavavolume2.chapter01;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author xinyi
 * @Date 2022/10/19 下午9:48
 */
public class StreamMap {

    public static void main(String[] args) throws IOException {

        List<String> words = new ArrayList<>();
        words.add("boat");
        // map
        // Stream<Stream<String>> streamStream = words.stream().map(w -> codePoints(w));
        // flatMap
        // Stream<String> stringStream = words.stream().flatMap(w -> codePoints(w));
        stream();

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

    public static void stream() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("/Users/guxinxin/Desktop/同意.txt")), StandardCharsets.UTF_8);
        List<String> words = List.of(contents.split("\\PL+"));
        words.stream().forEach(w -> System.out.println(w));
        long count = words.stream().filter(w -> w.length() > 2).count();
        System.out.println(count);

    }
}
