package main.java.ru.sgu.first;

import java.util.Objects;

public class Cat extends Animal implements Comparable<Cat>, Cloneable {

    private Kitty kitty;

    @Override
    String getNameOfAnimal() {
        return "This is cat and his name is " + super.name;
    }

    @Override
    public String getNoise() {
        return "Meow";
    }

    public Cat(String name) {
        super(name);
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
        return super.name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Cat o) {
        return this.name.compareTo(o.name);
    }


    public void setKitty(Kitty kitty) {
        this.kitty = kitty;
    }

    public Kitty getKitty() {
        return kitty;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepClone() throws CloneNotSupportedException {
        Cat cloneCat = (Cat) super.clone();
        cloneCat.kitty = (Kitty) cloneCat.kitty.clone();
        return cloneCat;
    }
}
