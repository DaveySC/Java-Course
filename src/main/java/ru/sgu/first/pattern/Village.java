package main.java.ru.sgu.first.pattern;

//leaf
public class Village implements Locality{
    private String name;
    private Integer population;

    public Village(String name, Integer population) {
        this.name = name;
        this.population = population;
    }

    public Integer getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public void printLocalityName() {
        System.out.println(this.name);
    }
}
