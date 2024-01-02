package com.xinyi.book.concurrency.chapter04;

import java.util.*;

/**
 * @author guxinxin
 */
public class HashMapShallowCopy {

    public static void main(String[] args) {

        HashMap<String,String> hashMap= new HashMap<String, String>();
        hashMap.put("行一","one");
        hashMap.put("行二","two");

        HashMap<String,String> hashMap2 = new HashMap<String, String>(hashMap);
        System.out.println("hashMap2 结果");
        for(Map.Entry< String,String> entry : hashMap2.entrySet()){
            System.out.println("key:" + entry.getKey());
            System.out.println("value:" + entry.getValue());
        }

        System.out.println("------");
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(new HashMap<>(hashMap));

        hashMap.put("行一新增","one add");
        // 报错
        // unmodifiableMap.put("行三","three");
        System.out.println("unmodifiableMap 结果");
        for(Map.Entry< String,String> entry : unmodifiableMap.entrySet()){
            System.out.println("key:" + entry.getKey());
            System.out.println("value:" + entry.getValue());
        }


    }
}
