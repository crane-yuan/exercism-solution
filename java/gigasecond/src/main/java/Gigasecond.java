import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime dateTime;

    public Gigasecond(LocalDate birthDate) {
        this.dateTime = birthDate.atStartOfDay();
    }

    public Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = birthDateTime;
    }

    public LocalDateTime getDate() {
        long gigasecond = 1_000_000_000L;
        
        return dateTime.plusSeconds(gigasecond);
    }

}
