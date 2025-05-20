package LLD.ChainOR;

// ATMDispenser.java
public class ATMDispenser implements Dispenser {
    private int denomination;
    private Dispenser next;

    public ATMDispenser(int denomination) {
        this.denomination = denomination;
    }

    public void setNext(Dispenser next) {
        this.next = next;
    }

    public void dispense(Request request) {
        if (!(request instanceof MoneyRequest)) {
            if (next != null) next.dispense(request);
            return;
        }

        MoneyRequest moneyRequest = (MoneyRequest) request;
        int amount = moneyRequest.amount;

        if (amount >= denomination) {
            int count = amount / denomination;
            int remainder = amount % denomination;
            System.out.println("Dispensing " + count + " x " + denomination + " notes");
            if (remainder != 0 && next != null) {
                next.dispense(new MoneyRequest(remainder));
            }
        } else if (next != null) {
            next.dispense(request);
        }
    }
}
