package main.java.ru.sgu.first.С;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private final static List<String> names = List.of("banana", "apple", "kinder", "crisp", "bread", "cake");
    private final MyQueue myQueue;
    private boolean running = false;
    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        running = true;
        produce();
    }

    public void produce() {
        while (running) {
            if(myQueue.isFull()) {
                try {
                    myQueue.waitIsNotFull();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            if (!running) {
                break;
            }
            myQueue.add(generateFood());
        }
    }

    private Food generateFood() {
        return new Food(names.get(ThreadLocalRandom.current().nextInt(0, 5 + 1)),
                ThreadLocalRandom.current().nextInt(100, 1000 + 1));
    }

    public void stop() {
        running = false;
        myQueue.notifyIsNotFull();
    }
}
