package com.xinyi.book.concurrency.chapter03;

import java.math.BigInteger;

/**
 * @author guxinxin
 *
 * 指令重排序
 * 在没有同步的情况下，编译器、处理器以及运行时等都可能 对操作的执行顺序进行一些意想不到的调整。在缺乏足够同步的多线程程序中，想要对内存操作的执行
 * 顺序进行判断，几乎是不可能的事情
 */
public class NoVisibility {

    public static boolean ready;
    public static int number;

    public static void main(String[] args) {

        new ReaderThread().start();
        number = 42;
        ready = true;
    }
    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }
}
