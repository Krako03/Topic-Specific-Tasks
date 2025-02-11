package com.griddynamics;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BusinessDaysIteratorTest {

    @Test
    void testIteratorOnFriday() {
        LocalDate firstDate = LocalDate.of(2021, 12, 31);
        LocalDate expectedDate = LocalDate.of(2022, 1, 3);
        System.out.println(firstDate.getDayOfWeek());
        System.out.println(expectedDate.getDayOfWeek());

        Iterator<LocalDate> iter = new BusinessDaysIterator(firstDate);

        assertEquals(expectedDate, iter.next());
    }

    @Test
    void testIteratorOnSaturday() {
        LocalDate firstDate = LocalDate.of(2022, 1, 1);
        LocalDate expectedDate = LocalDate.of(2022, 1, 3);
        System.out.println(firstDate.getDayOfWeek());
        System.out.println(expectedDate.getDayOfWeek());

        Iterator<LocalDate> iter = new BusinessDaysIterator(firstDate);

        assertEquals(expectedDate, iter.next());
    }

    @Test
    void testIteratorOnSunday() {
        LocalDate firstDate = LocalDate.of(2022, 1, 2);
        LocalDate expectedDate = LocalDate.of(2022, 1, 3);
        System.out.println(firstDate.getDayOfWeek());
        System.out.println(expectedDate.getDayOfWeek());

        Iterator<LocalDate> iter = new BusinessDaysIterator(firstDate);

        assertEquals(expectedDate, iter.next());
    }
}