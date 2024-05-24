package main.java.ru.sgu.first.С;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

    private final Queue<Food> queue = new LinkedList<>();
    private final int maxSize;
    private final Object IS_NOT_FULL = new Object();
    private final Object IS_NOT_EMPTY = new Object();

    MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public void waitIsNotFull() throws InterruptedException {
        synchronized (IS_NOT_FULL) {
            IS_NOT_FULL.wait();
        }
    }

    public void notifyIsNotFull() {
        synchronized (IS_NOT_FULL) {
            IS_NOT_FULL.notify();
        }
    }

    public void waitIsNotEmpty() throws InterruptedException {
        synchronized (IS_NOT_EMPTY) {
            IS_NOT_EMPTY.wait();
        }
    }


    public void notifyIsNotEmpty() {
        synchronized (IS_NOT_EMPTY) {
            IS_NOT_EMPTY.notify();
        }
    }

    public void add(Food food) {
        queue.add(food);
        notifyIsNotEmpty();
    }

    public Food remove() {
        Food food = queue.poll();
        notifyIsNotFull();
        return food;
    }

    public boolean isFull() {
        return queue.size() >= maxSize;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
