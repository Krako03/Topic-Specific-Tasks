package com.griddynamics;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;

public class BusinessDaysIterator implements Iterator<LocalDate> {
    private LocalDate actualDay;

    public BusinessDaysIterator(LocalDate actualDay) {
        this.actualDay = actualDay;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public LocalDate next() {
        actualDay = actualDay.plusDays(1);

        DayOfWeek day = actualDay.getDayOfWeek();
        if (day == DayOfWeek.SATURDAY) {
            actualDay = actualDay.plusDays(2);
        } else if (day == DayOfWeek.SUNDAY) {
            actualDay = actualDay.plusDays(1);
        }

        return actualDay;
    }
}
