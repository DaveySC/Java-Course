package main.java.ru.sgu.first;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task2 {

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of integers");
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(scanner.nextInt());
        }
        task2.solve(list);

    }

    public void solve(List<Integer> list) {
        System.out.println(list
                .stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null));

        System.out.println(list
                .stream()
                .sorted()
                .skip(2)
                .findFirst()
                .orElse(null));
    }
}
