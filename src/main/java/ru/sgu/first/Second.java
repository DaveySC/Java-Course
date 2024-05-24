package main.java.ru.sgu.first;

import java.util.Scanner;

enum DaysOfWeek {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;
}

public class Second {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dayIn = scanner.nextLine();
        Integer offsetIn = scanner.nextInt();
        DaysOfWeek day = DaysOfWeek.valueOf(dayIn);
        int nextDay = (day.ordinal() + offsetIn) % 7;
        System.out.println(DaysOfWeek.values()[nextDay]);
    }
}
