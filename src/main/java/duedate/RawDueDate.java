package duedate;

import java.time.LocalDateTime;

public class RawDueDate {

    private final LocalDateTime dueDate;

    public RawDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime correctNightAndWeekendIfNeeded() {
        LocalDateTime dueDateBetweenNineToFive = new NightCorrection().apply(dueDate);
        return new WeekendCorrection().apply(dueDateBetweenNineToFive);
    }
}
