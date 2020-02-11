package duedate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

class NightCorrection implements Function<LocalDateTime, LocalDateTime> {

    private static final LocalTime START_OF_BUSINESSDAY = LocalTime.of(9, 0);
    private static final LocalTime END_OF_BUSINESSDAY = LocalTime.of(17, 0);
    private static final int NON_WORKING_HOURS_PER_DAY = 16;

    @Override
    public LocalDateTime apply(LocalDateTime dateTime) {
        if (isAtNight(dateTime)) {
            return dateTime.plus(NON_WORKING_HOURS_PER_DAY, ChronoUnit.HOURS);
        }
        return dateTime;
    }

    private static boolean isAtNight(LocalDateTime dueDate) {
        LocalTime localTime = dueDate.toLocalTime();
        return localTime.isAfter(END_OF_BUSINESSDAY) || localTime.isBefore(START_OF_BUSINESSDAY);
    }
}
