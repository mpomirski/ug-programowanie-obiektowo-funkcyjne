import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Kalendarz implements Calendar {
    public enum weekDay {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
    private final java.util.HashMap<weekDay, ArrayList<Appointment>> planner = new HashMap<>();
    public Kalendarz(){
    }
    public Kalendarz addAppointment(Appointment appointment, weekDay day) throws IllegalArgumentException{
        this.planner.computeIfAbsent(day, k -> new ArrayList<>()).add(appointment);
        return this;
    }
    public java.util.HashMap<weekDay, ArrayList<Appointment>> getAllAppointments(){
        return this.planner;
    }

    public Kalendarz removeAppointmentOn(weekDay weekDay, Integer appointmentIndex){
        ArrayList<Appointment> appointments = this.planner.get(weekDay);
        Appointment toDelete = null;
        for (int i = 0; i < appointments.size(); i++) {
            if (i == appointmentIndex){
                appointments.remove(appointments.get(i));
            }
        }
        return this;
    }

    public Kalendarz removeAllOn(weekDay weekDay){
        this.planner.get(weekDay).clear();
        return this;
    }

    public ArrayList<Appointment> getAppointmentsByPriorityOn(weekDay weekDay, Spotkanie.Priorytet priorytet){
        java.util.List<Appointment> list = this.planner.get(weekDay).stream().filter(
                appointment -> appointment.getPriorytet().equals(priorytet)
        ).toList();
        return new ArrayList<>(list);
    }

    public ArrayList<Appointment> getAppointmentsByStartTimeOn(weekDay weekDay, LocalTime startTime){
        java.util.List<Appointment> list = this.planner.get(weekDay).stream().filter(
                appointment -> appointment.getStartTime().isAfter(startTime) || appointment.getStartTime().equals(startTime)
        ).toList();
        return new ArrayList<>(list);
    }

    public ArrayList<Appointment> getAppointmentsOn(weekDay weekDay){
        return this.planner.get(weekDay);
    }

    public Kalendarz generateAppointments(){
        int i = 10;
        for (weekDay weekDay: weekDay.values()){
            String opis = String.format("Opis spotkania %d", i);
            LocalTime startTime = LocalTime.parse(String.format("%d", i) + ":00:00");
            LocalTime endTime = LocalTime.parse(String.format("%d", i+1) + ":00:00");
            Spotkanie.Priorytet priorytet = Spotkanie.Priorytet.HIGH;
            Appointment appointment = new Spotkanie(opis, startTime, endTime, priorytet);
            this.addAppointment(appointment, weekDay);
            i++;
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        HashMap<Kalendarz.weekDay, ArrayList<Appointment>> appointments = getAllAppointments();
        if (appointments == null){
            return "";
        }
        for(Kalendarz.weekDay weekDay : Kalendarz.weekDay.values()){
            sb.append("----------------" + weekDay + "----------------\n");
            if (appointments.get(weekDay) != null) {
                for (Appointment appointment : appointments.get(weekDay)) {
                    if (appointment != null) {
                        sb.append(appointment + "\n");
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String asString(ArrayList<Appointment> appointments){
        StringBuilder sb = new StringBuilder();
        if (appointments == null){
            return "";
        }
        for (Appointment appointment : appointments){
            if (appointment != null) {
                sb.append(appointment + "\n");
            }
        }
        return sb.toString();
    }
}
