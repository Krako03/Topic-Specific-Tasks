package com.griddynamics;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BufferingIteratorTest {

    @Test
    public void testBufferingIterator() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);

        Iterator<List<Integer>> iterator = new BufferingIterator<>(input.iterator(), 3);

        List<Integer> batch1 = iterator.next();
        assertEquals(List.of(1, 2, 3), batch1);

        List<Integer> batch2 = iterator.next();
        assertEquals(List.of(4, 5), batch2);

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testBufferingIteratorSmallerBatch() {
        List<Integer> input = List.of(1, 2);

        Iterator<List<Integer>> iterator = new BufferingIterator<>(input.iterator(), 3);

        List<Integer> batch1 = iterator.next();
        assertEquals(List.of(1, 2), batch1);

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testBufferingIteratorEmpty() {
        List<Integer> input = List.of();

        Iterator<List<Integer>> iterator = new BufferingIterator<>(input.iterator(), 3);

        assertFalse(iterator.hasNext());
    }
}