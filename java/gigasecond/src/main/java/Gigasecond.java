import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

class Gigasecond {

    private LocalDateTime dateTime;

    public Gigasecond(LocalDate birthDate) {
        this.dateTime = birthDate.atStartOfDay();
    }

    public Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = birthDateTime;
    }

    public LocalDateTime getDate() {
        long gigasecond = (long) Math.pow(10, 9);
        long second = this.dateTime.atZone(ZoneId.systemDefault())
                                   .toEpochSecond();
        long sum = gigasecond + second;

        return LocalDateTime.ofInstant(Instant.ofEpochSecond(sum), TimeZone.getDefault()
                                                                           .toZoneId());
    }

}
