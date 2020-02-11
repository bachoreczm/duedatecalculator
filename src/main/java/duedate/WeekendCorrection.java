package duedate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

class WeekendCorrection implements Function<LocalDateTime, LocalDateTime> {

    private static final int NUM_OF_DAYS_PER_WEEKEND = 2;

    @Override
    public LocalDateTime apply(LocalDateTime dateTime) {
        if (isWeekend(dateTime)) {
            return dateTime.plus(NUM_OF_DAYS_PER_WEEKEND, ChronoUnit.DAYS);
        }
        return dateTime;
    }

    private boolean isWeekend(LocalDateTime dueDate) {
        DayOfWeek dayOfWeek = dueDate.toLocalDate().getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY);
    }
}
