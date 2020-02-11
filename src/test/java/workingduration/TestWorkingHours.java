package workingduration;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWorkingHours {

    @Test
    public void lessThenAWorkingDay() {
        int turningTime = 5;

        WorkingHours workingHours = new WorkingHours(turningTime);

        assertEquals(Duration.ofHours(turningTime), workingHours.calculateDuration());
    }

    @Test
    public void eightHours() {
        int turningTime = 8;

        WorkingHours workingHours = new WorkingHours(turningTime);

        assertEquals(Duration.ofHours(turningTime), workingHours.calculateDuration());
    }

    @Test
    public void moreThanOneWorkingDay() {
        int turningTime = 9;

        WorkingHours workingHours = new WorkingHours(turningTime);

        assertEquals(Duration.ofDays(1).plus(Duration.ofHours(1)), workingHours.calculateDuration());
    }

    @Test
    public void oneWeek() {
        int turningTime = 40;

        WorkingHours workingHours = new WorkingHours(turningTime);

        assertEquals(Duration.ofDays(4).plus(Duration.ofHours(8)), workingHours.calculateDuration());
    }

    @Test
    public void moreThanOneWorkingWeek() {
        int turningTime = 41;

        WorkingHours workingHours = new WorkingHours(turningTime);

        assertEquals(Duration.ofDays(7).plus(Duration.ofHours(1)), workingHours.calculateDuration());
    }
}