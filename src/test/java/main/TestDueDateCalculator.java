package main;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDueDateCalculator {

    @Test
    public void oneHourTurningTime() {
        LocalDateTime tuesdayThreePm = LocalDateTime.parse("2020-02-11T15:00:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayThreePm, 1);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-11T16:00:00"), dueDate);
    }

    @Test
    public void twoHourTurningTime() {
        LocalDateTime tuesdayHalfPastTwoPm = LocalDateTime.parse("2020-02-11T14:30:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayHalfPastTwoPm, 2);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-11T16:30:00"), dueDate);
    }

    @Test
    public void dueDateIsAfterEndOfWorkingDayOnThatDay() {
        LocalDateTime tuesdayThreePm = LocalDateTime.parse("2020-02-11T15:00:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayThreePm, 3);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-12T10:00:00"), dueDate);
    }

    @Test
    public void dueDateIsAfterEndOfWorkingDayOnNextDay() {
        LocalDateTime tuesdayFivePm = LocalDateTime.parse("2020-02-11T17:00:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayFivePm, 7);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-12T16:00:00"), dueDate);
    }

    @Test
    public void turningTimeIsMoreThanOneWorkingDayDueDateOnThisWeek() {
        LocalDateTime tuesdayFourPm = LocalDateTime.parse("2020-02-11T16:00:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayFourPm, 18);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-14T10:00:00"), dueDate);
    }

    @Test
    public void turningTimeIsMoreThanOneWorkingDayDueDateOnAnotherWeek() {
        LocalDateTime tuesdayFourPm = LocalDateTime.parse("2020-02-11T16:00:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayFourPm, 26);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-17T10:00:00"), dueDate);
    }

    @Test
    public void turningTimeIsMoreThanOneWeekDueDateOnAnotherWeek() {
        LocalDateTime tuesdayFourPm = LocalDateTime.parse("2020-02-11T16:00:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayFourPm, 66);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-24T10:00:00"), dueDate);
    }

    @Test
    public void turningTimeIsMoreThanOneWeekAndSubmitDateHasMinutes() {
        LocalDateTime tuesdayFourPm = LocalDateTime.parse("2020-02-11T16:02:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayFourPm, 66);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-24T10:02:00"), dueDate);
    }

    @Test
    public void endOfDayIsSameAsStartOfNextDay() {
        LocalDateTime tuesdayFourPm = LocalDateTime.parse("2020-02-11T09:00:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayFourPm, 8);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-11T17:00:00"), dueDate);
    }

    @Test
    public void endOfTheWeekIsSameAsStartOfTheNextWeek() {
        LocalDateTime tuesdayFourPm = LocalDateTime.parse("2020-02-10T09:00:00");
        DueDateCalculator dueDateCalculator = new DueDateCalculator(tuesdayFourPm, 40);

        LocalDateTime dueDate = dueDateCalculator.calculateDueDate();

        assertEquals(LocalDateTime.parse("2020-02-14T17:00:00"), dueDate);
    }

}
