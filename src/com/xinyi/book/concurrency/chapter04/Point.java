package com.xinyi.book.concurrency.chapter04;

/**
 * @author guxinxin
 */
public class Point {

    public final int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {

        Point point = new Point(3,4);


    }
}
