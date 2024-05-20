package main.java.ru.sgu;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Chose the problem! (print A, B or C)");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case ("A") -> FirstA.solve();
            case ("B") -> FirstB.solve();
            case ("C") -> FirstC.solve();
            default -> System.out.println("WRONG INPUT!");
        }
    }
}