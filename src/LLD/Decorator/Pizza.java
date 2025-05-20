package LLD.Decorator;

public class Pizza implements Food {
    public String getDescription() {
        return "Plain Pizza";
    }

    public double getCost() {
        return 5.00;
    }
}
