package main;

import duedate.RawDueDate;
import workingduration.WorkingHours;

import java.time.Duration;
import java.time.LocalDateTime;

public class DueDateCalculator {

    private final LocalDateTime submitDate;
    private final WorkingHours turningTime;

    public DueDateCalculator(LocalDateTime submitDate, int turningTime) {
        this.submitDate = submitDate;
        this.turningTime = new WorkingHours(turningTime);
    }

    public LocalDateTime calculate() {
        Duration duration = turningTime.calculateDuration();
        RawDueDate rawDueDate = new RawDueDate(submitDate.plus(duration));
        return rawDueDate.correctNightAndWeekendIfNeeded();
    }
}
