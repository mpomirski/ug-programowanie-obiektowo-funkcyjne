import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public interface Calendar {
    Calendar addAppointment(Appointment appointment, Kalendarz.weekDay day);
    java.util.HashMap<Kalendarz.weekDay, ArrayList<Appointment>> getAllAppointments();
    Calendar removeAppointmentOn(Kalendarz.weekDay weekDay, Integer appointmentIndex);
    Calendar removeAllOn(Kalendarz.weekDay weekDay);
    ArrayList<Appointment> getAppointmentsOn(Kalendarz.weekDay weekDay);
    ArrayList<Appointment> getAppointmentsByPriorityOn(Kalendarz.weekDay weekDay, Spotkanie.Priorytet priorytet);
    ArrayList<Appointment> getAppointmentsByStartTimeOn(Kalendarz.weekDay weekDay, LocalTime startTime);
    Calendar generateAppointments();
}
