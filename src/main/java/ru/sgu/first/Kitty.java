package main.java.ru.sgu.first;

public class Kitty extends Animal implements Cloneable{

    public Kitty(String name) {
        super(name);
    }

    @Override
    String getNameOfAnimal() {
        return super.name;
    }

    @Override
    public String getNoise() {
        return "This is the kitty!";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
