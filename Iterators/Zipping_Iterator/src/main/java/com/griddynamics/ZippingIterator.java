package com.griddynamics;

import java.util.Iterator;
import java.util.function.BiFunction;

public class ZippingIterator<A, B, C> implements Iterator<C> {
    private final Iterator<A> iterA;
    private final Iterator<B> iterB;
    private final BiFunction<A, B, C> zipper;

    public ZippingIterator(Iterator<A> iterA, Iterator<B> iterB, BiFunction<A, B, C> zipper) {
        this.iterA = iterA;
        this.iterB = iterB;
        this.zipper = zipper;
    }

    @Override
    public boolean hasNext() {
        return iterA.hasNext() && iterB.hasNext();
    }

    @Override
    public C next() {
        A a = iterA.next();
        B b = iterB.next();
        return zipper.apply(a, b);
    }
}
