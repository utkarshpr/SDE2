package LLD.Splitwise;


import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        User u1 = new User("1", "Alice");
        User u2 = new User("2", "Bob");
        User u3 = new User("3", "Charlie");

        Transaction tx = new Transaction(101L);

        // Equal Split
        tx.addTransaction(u1, 300.0, Arrays.asList(u2, u3), new EqualSplitStrategy());

        // Exact Split
        Map<User, Double> exact = new HashMap<>();
        exact.put(u2, 120.0);
        exact.put(u3, 180.0);
        tx.addTransaction(u1, 300.0, Arrays.asList(u2, u3), new ExactSplitStrategy(exact));


        System.out.println("\n--- Bob's Balance ---");
        tx.printUserBalance("2");
    }
}
