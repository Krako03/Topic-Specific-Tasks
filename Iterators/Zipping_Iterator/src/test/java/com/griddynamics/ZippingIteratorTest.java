package com.griddynamics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ZippingIteratorTest {

    @Test
    public void testZippingIterator() {
        List<Integer> listA = Arrays.asList(1, 2, 3);
        List<Integer> listB = Arrays.asList(10, 20, 30);

        // Zipper function to sum elements
        BiFunction<Integer, Integer, Integer> sumFunction = Integer::sum;

        // Create the ZippingIterator
        Iterator<Integer> iterator = new ZippingIterator<>(listA.iterator(), listB.iterator(), sumFunction);

        // Test each element
        assertEquals(11, iterator.next());
        assertEquals(22, iterator.next());
        assertEquals(33, iterator.next());

        // Test no more elements
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testZippingIteratorDifferentSizes() {
        List<Integer> listA = Arrays.asList(1, 2, 3);
        List<Integer> listB = Arrays.asList(10, 20);

        // Zipper function to sum elements
        BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;

        // Create the ZippingIterator
        Iterator<Integer> iterator = new ZippingIterator<>(listA.iterator(), listB.iterator(), sumFunction);

        // Test each element
        assertEquals(11, iterator.next());
        assertEquals(22, iterator.next());

        // Test no more elements
        assertFalse(iterator.hasNext());
    }
}