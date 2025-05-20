package LLD.Decorator;

public class Milk extends FoodDecorator {
    public Milk(Food food) {
        super(food);
    }

    public String getDescription() {
        return food.getDescription() + ", Milk";
    }

    public double getCost() {
        return food.getCost() + 0.75;
    }
}