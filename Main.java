import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void menu(GradeList gradeList){
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Wybierz co chcesz zrobić:");
            System.out.println("1. Dodaj ocenę\n2. Policz średnią\n3. Wyznacz maksimum\n4. Wyznacz minimum\n5. Zakończ");
            int option = in.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Wpisz jaką ocenę dodać:");
                    float newGrade = in.nextFloat();
                    try {
                        gradeList.addGrade(newGrade);
                        System.out.printf("Dodano ocenę: %,.2f\n", newGrade);
                    }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.printf("Średnia z ocen wynosi: %f\n", gradeList.getAvg());
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.printf("Maksimum z ocen wynosi: %f\n", gradeList.getMax());
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.printf("Minimum z ocen wynosi: %f\n", gradeList.getMin());
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> exit = true;
                default -> System.out.println("Zła opcja");
            }
        }
    }
    public static void main(String[] args) {
        GradeList gradeList = new GradeList();
        System.out.println("Witaj! To jest program do liczenia średniej/min/max z listy ocen.");
        menu(gradeList);
    }
}
