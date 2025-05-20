package LLD.ChainOR;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- ATM Example -----");

        // ATM Dispensers
        Dispenser d2000 = new ATMDispenser(2000);
        Dispenser d500 = new ATMDispenser(500);
        Dispenser d100 = new ATMDispenser(100);

        d2000.setNext(d500);
        d500.setNext(d100);

        // Simulate ATM withdrawal
        d2000.dispense(new MoneyRequest(3700));

        System.out.println("\n----- Vending Machine Example -----");

        // Vending Machine Dispensers
        Dispenser chips = new VendingDispenser("A1", "Chips", 2);
        Dispenser soda = new VendingDispenser("B2", "Soda", 1);
        Dispenser candy = new VendingDispenser("C3", "Candy", 0);

        chips.setNext(soda);
        soda.setNext(candy);

        // Simulate item selection
        chips.dispense(new ItemRequest("B2"));
        chips.dispense(new ItemRequest("C3"));
        chips.dispense(new ItemRequest("A1"));
    }
}
