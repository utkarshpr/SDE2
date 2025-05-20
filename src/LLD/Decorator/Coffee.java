package LLD.Decorator;

public class Coffee implements Food {
    public String getDescription() {
        return "Black Coffee";
    }

    public double getCost() {
        return 3.00;
    }
}