package com.xinyi.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guxinxin
 * @version 1.0.0
 * @Description TODO
 * @createTime 2023年08月23日 11:01:00
 */
public class Demo4 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "1", "2", "3");

        List<List<String>> lists = partitionList(strings, 20);
        lists.stream().forEach(t -> System.out.println(t));
    }

    private static <T> List<List<T>> partitionList(List<T> list, int batchSize) {
        List<List<T>> partitions = new ArrayList<>();
        int size = list.size();
        int mod = size % batchSize;
        int numPartitions = size / batchSize + (mod == 0 ? 0 : 1);

        for (int i = 0; i < numPartitions; i++) {
            int start = i * batchSize;
            int end = Math.min(start + batchSize, size);
            partitions.add(list.subList(start, end));
        }
        return partitions;
    }
}

