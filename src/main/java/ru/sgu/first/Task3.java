package main.java.ru.sgu.first;

import main.java.ru.sgu.first.pattern.City;
import main.java.ru.sgu.first.pattern.District;
import main.java.ru.sgu.first.pattern.Village;

public class Task3 {
    public static void main(String[] args) {
        City city = new City("Volgograd", 100_000);
        District district = new District("arbat", 100);
        Village village = new Village("kokosov", 1_000);
        city.addLocality(district);
        city.addLocality(village);
        city.printLocalityName();
    }
}
