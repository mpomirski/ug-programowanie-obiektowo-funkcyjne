import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void viewByDay(Calendar kalendarz){
        System.out.println("Wybierz dzień:");
        System.out.println("1. Poniedziałek");
        System.out.println("2. Wtorek");
        System.out.println("3. Środa");
        System.out.println("4. Czwartek");
        System.out.println("5. Piątek");
        System.out.println("6. Sobota");
        System.out.println("7. Niedziela");
        java.util.Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.MONDAY)));
            case 2 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.TUESDAY)));
            case 3 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.WEDNESDAY)));
            case 4 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.THURSDAY)));
            case 5 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.FRIDAY)));
            case 6 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.SATURDAY)));
            case 7 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.SUNDAY)));
        }
    }

    public static Kalendarz.weekDay getWeekdayByInt(int n){
        switch (n){
            case 1: return Kalendarz.weekDay.MONDAY;
            case 2: return Kalendarz.weekDay.TUESDAY;
            case 3: return Kalendarz.weekDay.WEDNESDAY;
            case 4: return Kalendarz.weekDay.THURSDAY;
            case 5: return Kalendarz.weekDay.FRIDAY;
            case 6: return Kalendarz.weekDay.SATURDAY;
            case 7: return Kalendarz.weekDay.SUNDAY;
        }
        return Kalendarz.weekDay.MONDAY;
    }
    public static void viewByDayByPriority(Calendar kalendarz){
        System.out.println("Wybierz dzień:");
        System.out.println("1. Poniedziałek");
        System.out.println("2. Wtorek");
        System.out.println("3. Środa");
        System.out.println("4. Czwartek");
        System.out.println("5. Piątek");
        System.out.println("6. Sobota");
        System.out.println("7. Niedziela");
        java.util.Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println("Wybierz priorytet:");
        System.out.println("1. Najwyższy");
        System.out.println("2. Wysoki");
        System.out.println("3. Normalny");
        int priorityInt = sc.nextInt();
        Spotkanie.Priorytet priorytet = Spotkanie.Priorytet.NORMAL;
        switch (priorityInt){
            case 1 -> priorytet = Spotkanie.Priorytet.HIGHEST;
            case 2 -> priorytet = Spotkanie.Priorytet.HIGH;
            case 3 -> priorytet = Spotkanie.Priorytet.NORMAL;
        }
        System.out.println(Kalendarz.asString(kalendarz.getAppointmentsByPriorityOn(getWeekdayByInt(choice), priorytet)));
    }

    public static void addAppointment(Calendar kalendarz){
        System.out.println("Wybierz dzień:");
        System.out.println("1. Poniedziałek");
        System.out.println("2. Wtorek");
        System.out.println("3. Środa");
        System.out.println("4. Czwartek");
        System.out.println("5. Piątek");
        System.out.println("6. Sobota");
        System.out.println("7. Niedziela");
        java.util.Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        System.out.println("Wpisz godzinę rozpoczęcia (HH:MM:SS):");
        sc.nextLine();
        String start = sc.nextLine();
        LocalTime parsedStart = LocalTime.parse(start);

        System.out.println("Wpisz godzinę zakończenia (HH:MM:SS):");
        String end = sc.nextLine();
        LocalTime parsedEnd = LocalTime.parse(end);

        System.out.println("Wybierz priorytet:");
        System.out.println("1. Najwyższy");
        System.out.println("2. Wysoki");
        System.out.println("3. Normalny");
        int priorityInt = sc.nextInt();
        Spotkanie.Priorytet priorytet = Spotkanie.Priorytet.NORMAL;
        switch (priorityInt){
            case 1 -> priorytet = Spotkanie.Priorytet.HIGHEST;
            case 2 -> priorytet = Spotkanie.Priorytet.HIGH;
            case 3 -> priorytet = Spotkanie.Priorytet.NORMAL;
        }
        System.out.println("Wpisz opis:");
        String description = sc.nextLine();
        Appointment appointment = new Spotkanie(description, parsedStart, parsedEnd, priorytet);
        kalendarz.addAppointment(appointment, getWeekdayByInt(choice));
    }

    public static void removeAppointment(Calendar kalendarz){
        System.out.println("Wybierz dzień:");
        System.out.println("1. Poniedziałek");
        System.out.println("2. Wtorek");
        System.out.println("3. Środa");
        System.out.println("4. Czwartek");
        System.out.println("5. Piątek");
        System.out.println("6. Sobota");
        System.out.println("7. Niedziela");
        java.util.Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.MONDAY)));
            case 2 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.TUESDAY)));
            case 3 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.WEDNESDAY)));
            case 4 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.THURSDAY)));
            case 5 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.FRIDAY)));
            case 6 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.SATURDAY)));
            case 7 -> System.out.println(Kalendarz.asString(kalendarz.getAppointmentsOn(Kalendarz.weekDay.SUNDAY)));
        }
        System.out.println("Wpisz który wpis z kolei chcesz usunąć");
        int choice2 = sc.nextInt();

        kalendarz.removeAppointmentOn(getWeekdayByInt(choice), choice2-1);
    }

    public static void viewByDayByTime(Calendar kalendarz){
        System.out.println("Wybierz dzień:");
        System.out.println("1. Poniedziałek");
        System.out.println("2. Wtorek");
        System.out.println("3. Środa");
        System.out.println("4. Czwartek");
        System.out.println("5. Piątek");
        System.out.println("6. Sobota");
        System.out.println("7. Niedziela");
        java.util.Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println("Wpisz godzinę (HH:MM:SS):");
        String time = sc.nextLine();
        LocalTime parsed = LocalTime.parse(time);
        System.out.println(Kalendarz.asString(kalendarz.getAppointmentsByStartTimeOn(getWeekdayByInt(choice), parsed)));
    }
    public static int menu(){
        System.out.println("1. Pokaż kalendarz");
        System.out.println("2. Pokaż spotkania danego dnia");
        System.out.println("3. Pokaż spotkania danego dnia o danym priorytecie");
        System.out.println("4. Pokaż spotkania danego dnia zaczynające się nie wcześniej niż");

        System.out.println("5. Dodaj spotkanie");
        System.out.println("6. Dodaj przykładowe spotkania");

        System.out.println("7. Usuń spotkanie");
        System.out.println("0. Zakończ");
        java.util.Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
    public static void handleMenu(Calendar kalendarz) {

        int selection = 1;
        while (selection != 0) {
            selection = menu();
            switch (selection) {
                case 1 -> {
                    if (kalendarz.getAllAppointments().isEmpty()){
                        System.out.println("Kalendarz pusty.");
                    } else {
                        System.out.println(kalendarz);
                    }
                }
                case 2 -> viewByDay(kalendarz);
                case 3 -> viewByDayByPriority(kalendarz);
                case 4 -> viewByDayByTime(kalendarz);
                case 5 -> addAppointment(kalendarz);
                case 6 -> kalendarz.generateAppointments();
                case 7 -> removeAppointment(kalendarz);
                case 0 -> System.out.println();
                default -> System.out.println("Błędny wybór");
            }
        }
    }
    public static void introduction(){
        System.out.println("To jest program do zarządzania spotkaniami w ciągu tygodnia.");
    }
    public static void main(String[] args) {
        Kalendarz kalendarz = new Kalendarz();
        introduction();
        handleMenu(kalendarz);
    }
}