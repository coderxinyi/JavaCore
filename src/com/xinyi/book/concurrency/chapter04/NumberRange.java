package com.xinyi.book.concurrency.chapter04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guxinxin
 */
public class NumberRange {

    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    private static final Object object = new Object();

    public void setLower(int i){
        synchronized (object){
            if (i > upper.get()){
                throw new IllegalArgumentException("can't set lower to " + i + " > upper");
            }{
                lower.set(i);
            }
        }
    }
    public void setUpper(int i){
        synchronized (object){
            if (i < lower.get()){
                throw new IllegalArgumentException("can't set upper to " + i + " < lower");
            }else {
                upper.set(i);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        NumberRange numberRange = new NumberRange();
        new Thread(()->{
            numberRange.setLower(5);
        }).start();
        new Thread(()->{
            numberRange.setUpper(4);
        }).start();

        System.out.println("lower: " + numberRange.lower.get());
        System.out.println("upper: " + numberRange.upper.get());
    }
}
