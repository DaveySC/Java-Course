package main.java.ru.sgu.first;

import java.util.Objects;

public class Cat extends Animal implements Comparable<Cat>{

    public Cat(String name) {
        super(name);
    }

    @Override
    String getNameOfAnimal() {
        return "This is cat and his name is " + super.name;
    }

    @Override
    public String getNoise() {
        return "Meow";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cat other = (Cat) obj;
        if (!Objects.equals(name, other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (int) ((Math.random() * (1_000_000 - 2)) + 2);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Cat o) {
        return this.name.compareTo(o.name);
    }
}
