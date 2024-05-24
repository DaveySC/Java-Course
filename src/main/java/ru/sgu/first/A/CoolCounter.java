package main.java.ru.sgu.first.A;

public class CoolCounter {
    private int count = 0;
    private final Object OBJ_TO_SYNCH = new Object();

    public void increment() {
        synchronized (OBJ_TO_SYNCH) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
