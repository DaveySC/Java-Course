package main.java.ru.sgu.first.B;

import java.util.concurrent.RecursiveTask;

public class Fib extends RecursiveTask<Integer> {
    private final int number;

    public Fib(int number) {
        this.number =  number;
    }

    @Override
    protected Integer compute() {
        if (number <= 1) {
            return number;
        } else {
            Fib fib1 = new Fib(number - 1);
            Fib fib2 = new Fib(number - 2);
            fib1.fork();
            return fib2.compute() + fib1.join();
        }
    }
}
