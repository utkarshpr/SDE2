package LLD.Decorator;

public class Olives extends FoodDecorator {
    public Olives(Food food) {
        super(food);
    }

    public String getDescription() {
        return food.getDescription() + ", Olives";
    }

    public double getCost() {
        return food.getCost() + 1.00;
    }
}