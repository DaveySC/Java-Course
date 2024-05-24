package main.java.ru.sgu.first;

import java.util.concurrent.ThreadLocalRandom;

public class Third {
    private final Integer RANDOM_STRING_LENGTH = 10;
    private final Integer COUNT = 100_000;
    private char[] randomStr = new char[RANDOM_STRING_LENGTH];

    public static void main(String[] args) {
        Third third = new Third();
        third.solve();
    }

    void solve() {
        calcStringBuffer();
        calcStringBuilder();
        calcString();
    }

    void calcStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        long startTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) stringBuilder.append(generateRandomString());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Для StringBuilder: " + duration);
    }

    void calcStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        long startTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) stringBuffer.append(generateRandomString());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Для StringBuffer: " + duration);
    }

    void calcString() {
        String string = new String();
        long startTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) string += (generateRandomString());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Для String: " + duration);
    }


    String generateRandomString() {
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            randomStr[i] = (char) ThreadLocalRandom.current().nextInt(97, 122 + 1);
        }
        return new String(randomStr);
    }
}