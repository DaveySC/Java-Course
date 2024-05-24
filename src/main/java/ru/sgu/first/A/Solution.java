package main.java.ru.sgu.first.A;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        CoolCounter coolCounter = new CoolCounter();

        for (int i = 0; i < 20; i++) {

            Thread myThread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        coolCounter.increment();

                    }
                }
            });

            Thread myThread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        coolCounter.increment();
                    }
                }
            });

            myThread1.start();
            myThread2.start();

            myThread1.join();
            myThread2.join();

            System.out.println(coolCounter.getCount());
        }
    }
}