package LLD.ChainOR;

import java.util.HashMap;
import java.util.*;

public class VendingDispenser implements Dispenser{
    private String code;
    private String item;
    private Dispenser next;
    private static Map<String, Integer> inventory = new HashMap<>();

    public VendingDispenser(String code, String item, int count) {
        this.code = code;
        this.item = item;
        inventory.put(code, count);
    }

    public void setNext(Dispenser next) {
        this.next = next;
    }

    public void dispense(Request request) {
        if (!(request instanceof ItemRequest)) {
            if (next != null) next.dispense(request);
            return;
        }

        ItemRequest itemRequest = (ItemRequest) request;

        if (this.code.equals(itemRequest.itemCode)) {
            int stock = inventory.getOrDefault(code, 0);
            if (stock > 0) {
                System.out.println("Dispensing: " + item);
                inventory.put(code, stock - 1);
            } else {
                System.out.println(item + " is out of stock.");
            }
        } else if (next != null) {
            next.dispense(request);
        }
    }
}
