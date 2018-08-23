import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        this.dateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = birthDateTime;
    }

    LocalDateTime getDate() {
        long gigasecond = (long) Math.pow(10, 9);
        long second = this.dateTime.atZone(ZoneId.systemDefault())
                                   .toEpochSecond();
        long sum = gigasecond + second;

        LocalDateTime resultDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(sum), TimeZone.getDefault()
                                                                                               .toZoneId());
        return resultDate;
    }

}
