package workingduration;

import java.time.Duration;

public class WorkingHours {

    private static final int WORKING_HOURS_PER_DAY = 8;
    private static final int NON_WORKING_HOURS_PER_DAY = 16;
    private static final int WORKING_HOURS_PER_WEEK = 40;
    private static final int HOURS_PER_WEEKEND = 48;
    private final int workingHours;
    private int durationInHours;

    public WorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public Duration calculateDuration() {
        initWithWorkingHours();
        addNonWorkingHoursAtNight();
        addWeekend();
        return Duration.ofHours(durationInHours);
    }

    private void initWithWorkingHours() {
        durationInHours = workingHours;
    }

    private void addNonWorkingHoursAtNight() {
        int workingDays = (workingHours - 1) / WORKING_HOURS_PER_DAY;
        durationInHours += NON_WORKING_HOURS_PER_DAY * workingDays;
    }

    private void addWeekend() {
        int workingWeeks = (workingHours - 1) / WORKING_HOURS_PER_WEEK;
        durationInHours += HOURS_PER_WEEKEND * workingWeeks;
    }
}
