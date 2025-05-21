package LLD.Splitwise;

import java.util.*;

public class ExactSplitStrategy implements Strategy {
    private final Map<User, Double> exactAmounts;

    public ExactSplitStrategy(Map<User, Double> exactAmounts) {
        this.exactAmounts = exactAmounts;
    }

    @Override
    public Map<User, Double> splitAmount(User paidBy, double totalAmount, List<User> borrowedUsers) {
        double total = exactAmounts.values().stream().mapToDouble(Double::doubleValue).sum();

        if (Math.abs(total - totalAmount) > 0.01) {
            throw new IllegalArgumentException("Exact amounts don't sum to total.");
        }

        Map<User, Double> map = new HashMap<>();
        for (User user : borrowedUsers) {
            map.put(user, exactAmounts.getOrDefault(user, 0.0));
        }
        return map;
    }
}
