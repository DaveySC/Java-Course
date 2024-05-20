package main.java.ru.sgu.first;

public class Dog extends Animal implements Noisy{

    public Dog(String name) {
        super(name);
    }

    @Override
    String getNameOfAnimal() {
        return "This is dog and his name is " + super.name;
    }

    @Override
    public String getNoise() {
        return "Gav";
    }
}
