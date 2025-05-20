package LLD.Decorator;

// Main.java
public class Main {
    public static void main(String[] args) {

        // Pizza order
        Food myPizza = new Pizza();
        myPizza = new Cheese(myPizza);
        myPizza = new Olives(myPizza);
        System.out.println("Pizza Order: " + myPizza.getDescription());
        System.out.println("Total Cost: $" + myPizza.getCost());

        System.out.println("--------------------------");

        // Coffee order
        Food myCoffee = new Coffee();
        myCoffee = new Milk(myCoffee);
        myCoffee = new Sugar(myCoffee);
        System.out.println("Coffee Order: " + myCoffee.getDescription());
        System.out.println("Total Cost: $" + myCoffee.getCost());
    }
}
