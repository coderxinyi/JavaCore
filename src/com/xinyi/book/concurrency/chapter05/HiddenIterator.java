package com.xinyi.book.concurrency.chapter05;

import net.jcip.annotations.GuardedBy;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author guxinxin
 */
public class HiddenIterator {

    @GuardedBy("this")
    private final Set<Integer> set = new HashSet<Integer>();

    public synchronized void add(Integer i){
        set.add(i);
    }
    public synchronized void remove(Integer i){
        set.remove(i);
    }
    public void addTenThings(){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            add(random.nextInt());
        }
        System.out.println("set: "  + set);
    }


    public static void main(String[] args) throws IOException {

        HiddenIterator hiddenIterator = new HiddenIterator();
        hiddenIterator.addTenThings();

        new Thread(() -> {
            hiddenIterator.addTenThings();
            System.out.println("--------------------------------");
        }).start();
    }
}
