import java.time.LocalTime;



public class Spotkanie implements Appointment {
     public enum Priorytet {
        NORMAL,
        HIGH,
        HIGHEST
    }
    private String opis;
    private LocalTime startTime;
    private LocalTime endTime;
    private Priorytet priorytet;
    private static final LocalTime earliestPossibleTime = LocalTime.MIN;

    public Spotkanie(String opis, LocalTime startTime, LocalTime endTime, Priorytet priorytet) throws IllegalArgumentException {
        this.opis = opis;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priorytet = priorytet;
        if (startTime.isBefore(earliestPossibleTime)){
            throw new IllegalArgumentException("Cannot start a meeting before the earliestPossibleTime");
        }
    }

    public LocalTime getEarliestPossibleTime() {
        return earliestPossibleTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Priorytet getPriorytet() {
        return priorytet;
    }

    public String getOpis() {
        return opis;
    }

    @Override
    public String toString() {
        return String.format("Najwcześniejszy możliwy czas: %s\n" +
                "Czas rozpoczęcia: %s\n" +
                "Czas zakończenia: %s\n" +
                "Priorytet: %s\n" +
                "Opis: %s",
                earliestPossibleTime, startTime, endTime, priorytet.toString(), opis
        );
    }
}
