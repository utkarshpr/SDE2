package LLD.Decorator;

public class Cheese extends FoodDecorator {
    public Cheese(Food food) {
        super(food);
    }

    public String getDescription() {
        return food.getDescription() + ", Cheese";
    }

    public double getCost() {
        return food.getCost() + 1.50;
    }
}