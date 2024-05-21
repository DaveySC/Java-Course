package main.java.ru.sgu.first;

import java.util.ArrayList;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Barsik"));
        animals.add(new Dog("super dog"));

        for (Animal animal : animals) {
            System.out.println(animal.getNameOfAnimal());
            System.out.println(animal.getNoise());
        }
        
    }
}
