package main.java.ru.sgu.first;

public abstract class Animal implements Noisy{
    String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract String getNameOfAnimal();
}
