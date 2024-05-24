package main.java.ru.sgu.first.B;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Main {
    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();

        final ForkJoinTask<Integer> res = forkJoinPool.submit(new Fib(20));

        System.out.println(res.join());
    }
}
