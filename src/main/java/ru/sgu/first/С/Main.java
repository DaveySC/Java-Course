package main.java.ru.sgu.first.С;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int MAX_QUEUE_CAPACITY = 100;
        final int producerCount = 3;
        final int consumerCount = 5;

        MyQueue myQueue = new MyQueue(MAX_QUEUE_CAPACITY);

        List<Producer> producers = new ArrayList<>();
        for(int i = 0; i < producerCount; i++) {
            Producer producer = new Producer(myQueue);
            Thread producerThread = new Thread(producer);
            producerThread.start();
            producers.add(producer);
        }

        List<Consumer> consumers = new ArrayList<>();
        for(int i = 0; i < consumerCount; i++) {
            Consumer consumer = new Consumer(myQueue);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
            consumers.add(consumer);
        }



        consumers.forEach(Consumer::stop);
        producers.forEach(Producer::stop);
    }
}
