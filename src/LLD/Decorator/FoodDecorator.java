package LLD.Decorator;

// FoodDecorator.java
public abstract class FoodDecorator implements Food {
    protected Food food;

    public FoodDecorator(Food food) {
        this.food = food;
    }

    public String getDescription() {
        return food.getDescription();
    }

    public double getCost() {
        return food.getCost();
    }
}
