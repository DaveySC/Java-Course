package main.java.ru.sgu.first.pattern;

import java.util.ArrayList;
import java.util.List;

//composite element
public class City implements Locality{
    private String name;
    private Integer population;

    private List<Locality> childrenLocality;

    public City(String name, Integer population) {
        this.name = name;
        this.population = population;
        this.childrenLocality = new ArrayList<>();
    }

    public Integer getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLocality(Locality locality) {
        childrenLocality.add(locality);
    }

    public void removeLocality(Locality locality) {
        childrenLocality.remove(locality);
    }

    @Override
    public void printLocalityName() {
        childrenLocality.forEach(Locality::printLocalityName);
    }
}

