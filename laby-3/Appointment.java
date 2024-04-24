import java.time.LocalTime;

public interface Appointment {
    LocalTime getEarliestPossibleTime();
    LocalTime getStartTime();
    LocalTime getEndTime();
    Spotkanie.Priorytet getPriorytet();
    String getOpis();
}
