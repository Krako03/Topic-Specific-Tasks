package com.griddynamics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

public class BufferingIterator<T> implements Iterator<List<T>> {
    private final Iterator<T> iter;
    private final int n;

    public BufferingIterator(Iterator<T> iter, int n) {
        this.iter = iter;
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public List<T> next() {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (iter.hasNext()) {
                list.add(iter.next());
            } else {
                break;
            }
        }

        return list;
    }
}
