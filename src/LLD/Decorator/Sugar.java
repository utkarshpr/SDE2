package LLD.Decorator;

// Sugar.java
public class Sugar extends FoodDecorator {
    public Sugar(Food food) {
        super(food);
    }

    public String getDescription() {
        return food.getDescription() + ", Sugar";
    }

    public double getCost() {
        return food.getCost() + 0.25;
    }
}