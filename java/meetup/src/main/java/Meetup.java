import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Meetup {

    private int year;
    private int month;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        LocalDate result = LocalDate.of(year, month, 1);
        switch (meetupSchedule) {
            case FIRST:
                return result.with(TemporalAdjusters.firstInMonth(dayOfWeek));
            case SECOND:
                return result.with(TemporalAdjusters.dayOfWeekInMonth(2, dayOfWeek));
            case THIRD:
                return result.with(TemporalAdjusters.dayOfWeekInMonth(3, dayOfWeek));
            case FOURTH:
                return result.with(TemporalAdjusters.dayOfWeekInMonth(4, dayOfWeek));
            case LAST:
                return result.with(TemporalAdjusters.lastInMonth(dayOfWeek));
            case TEENTH:
                result = result.with(TemporalAdjusters.firstInMonth(dayOfWeek));
                while (!(result.getDayOfMonth() >= 13 && result.getDayOfMonth() <= 19)) {
                    result = result.with(TemporalAdjusters.next(dayOfWeek));
                }
        }
        return result;
    }
}
