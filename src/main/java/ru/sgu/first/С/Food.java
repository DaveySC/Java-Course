package main.java.ru.sgu.first.С;

public class Food {

    private String foodName;

    private int calories;

    public Food(String name, int calories) {
        this.foodName = name;
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
