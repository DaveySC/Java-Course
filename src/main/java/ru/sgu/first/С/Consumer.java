package main.java.ru.sgu.first.С;

public class Consumer implements Runnable {
    private final MyQueue myQueue;
    private int totalCalories = 0;
    private boolean running = false;

    public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        running = true;
        consume();
    }

    public void consume() {
        while (running) {
            if(myQueue.isEmpty()) {
                try {
                    myQueue.waitIsNotEmpty();
                } catch (InterruptedException e) {
                    break;
                }
            }
            if (!running) {
                break;
            }
            Food food = myQueue.remove();
            printInfo(food);
        }
    }

    private void printInfo(Food food) {
        this.totalCalories += food.getCalories();
        System.out.println(STR."Поток \{Thread.currentThread().getName()} скушал \{food.getFoodName()} и всего получил \{this.totalCalories} калорий.");
    }


    public void stop() {
        running = false;
        myQueue.notifyIsNotEmpty();
    }
}