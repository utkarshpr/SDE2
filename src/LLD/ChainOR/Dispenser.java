package LLD.ChainOR;

// Dispenser.java
public interface Dispenser {
    void setNext(Dispenser next);
    void dispense(Request request);
}
