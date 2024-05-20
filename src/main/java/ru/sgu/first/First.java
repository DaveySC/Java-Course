package main.java.ru.sgu.first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class First {
    private BufferedReader br;
    List<ObjToCompare> objects;

    public First() throws IOException {
        br = new BufferedReader(new FileReader("src/main/java/ru/sgu/first/resources/input.txt"));
        objects = new ArrayList<>();
    }

    public static void main(String[] args) {
        First first = null;
        try {
            first = new First();
        } catch (IOException e) {
            System.out.println("Something wrong with files");
            System.exit(1);
        }
        first.solve();
    }

    private void solve() {
        read();
        removeDuplicates();
        Collections.sort(objects);
        for (ObjToCompare obj : objects) System.out.println(obj.toString());
    }

    private void removeDuplicates() {
        Set<ObjToCompare> set = new HashSet<>(objects.size());
        objects.removeIf(p -> !set.add(p));
    }


    private void read() {
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                objects.add(new ObjToCompare(line.split("\\s+")));
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Wrong Data!");
            System.exit(1);
        }
    }
}
