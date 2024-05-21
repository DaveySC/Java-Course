package main.java.ru.sgu.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of integers");
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(scanner.nextInt());
        }
        task1.solve(list.stream());

    }

    public void solve(Stream<Integer> stream) {
        System.out.println(stream.filter(x -> x > 10).collect(Collectors.toList()));
    }
}
