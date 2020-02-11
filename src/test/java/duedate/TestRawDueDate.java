package duedate;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRawDueDate {

    @Test
    public void dueDateInTheMiddleOfBusinessDay() {
        LocalDateTime dueDate = LocalDateTime.parse("2020-02-11T13:00:00");
        RawDueDate rawDueDate = new RawDueDate(dueDate);

        assertEquals(dueDate, rawDueDate.correctNightAndWeekendIfNeeded());
    }

    @Test
    public void tuesdayNight() {
        LocalDateTime dueDate = LocalDateTime.parse("2020-02-11T22:00:00");
        RawDueDate rawDueDate = new RawDueDate(dueDate);

        assertEquals(LocalDateTime.parse("2020-02-12T14:00:00"), rawDueDate.correctNightAndWeekendIfNeeded());
    }

    @Test
    public void fridayNight() {
        LocalDateTime dueDate = LocalDateTime.parse("2020-02-14T22:00:00");
        RawDueDate rawDueDate = new RawDueDate(dueDate);

        assertEquals(LocalDateTime.parse("2020-02-17T14:00:00"), rawDueDate.correctNightAndWeekendIfNeeded());
    }
}