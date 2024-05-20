package main.java.ru.sgu.first;

import java.util.Objects;

public class ObjToCompare implements Comparable<ObjToCompare> {
    private String name;
    private String surname;
    private String patronymic;
    private String companyName;
    private Integer rating;


    public ObjToCompare(String name,
                        String surname,
                        String patronymic,
                        String companyName,
                        int rating) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.companyName = companyName;
        this.rating = rating;
    }

    public ObjToCompare(String[] params) {
        if (params.length != 5) throw new IllegalArgumentException();
        this.name = params[0];
        this.surname = params[1];
        this.patronymic = params[2];
        this.companyName = params[3];
        this.rating = Integer.valueOf(params[4]);
    }
    @Override
    public int hashCode() {
        return (int) ((Math.random() * (1_000_000 - 2)) + 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ObjToCompare other = (ObjToCompare) obj;
        if (!Objects.equals(name, other.name))
            return false;
        if (!Objects.equals(surname, other.surname))
            return false;
        if (!Objects.equals(patronymic, other.patronymic))
            return false;
        if (!Objects.equals(companyName, other.companyName))
            return false;
        if (!Objects.equals(rating, other.rating))
            return false;
        return true;
    }

    @Override
    public int compareTo(ObjToCompare o) {
        if (rating.compareTo(o.rating) != 0)
            return o.rating.compareTo(rating);
        if (o.surname.compareTo(surname) != 0)
            return surname.compareTo(o.surname);
        if (name.compareTo(o.name) != 0)
            return o.name.compareTo(name);
        return patronymic.compareTo(o.patronymic);
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + patronymic + " " + companyName + " " + rating;
    }
}
