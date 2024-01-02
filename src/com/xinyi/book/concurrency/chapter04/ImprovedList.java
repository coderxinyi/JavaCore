package com.xinyi.book.concurrency.chapter04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guxinxin
 */
public abstract class ImprovedList<T> implements List<T> {

    private final List<T> list;

    public ImprovedList(List<T> list) {
        this.list = list;
    }

}
