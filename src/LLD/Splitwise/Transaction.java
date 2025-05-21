package LLD.Splitwise;


import java.util.*;

public class Transaction {
    private Long id;
    private List<Split> transactions;
    private Map<User, Double> balanceSheet;

    public Transaction(Long id) {
        this.id = id;
        this.transactions = new ArrayList<>();
        this.balanceSheet = new HashMap<>();
    }

    public void addTransaction(User paidBy, double amount, List<User> borrowedUsers, Strategy strategy) {
        Split split = new Split(paidBy, amount, borrowedUsers, strategy);
        transactions.add(split);

        Map<User, Double> splitMap = strategy.splitAmount(paidBy, amount, borrowedUsers);
        for (Map.Entry<User, Double> entry : splitMap.entrySet()) {
            User borrower = entry.getKey();
            double borrowedAmount = entry.getValue();

            balanceSheet.put(borrower, balanceSheet.getOrDefault(borrower, 0.0) - borrowedAmount);
            balanceSheet.put(paidBy, balanceSheet.getOrDefault(paidBy, 0.0) + borrowedAmount);
        }

        System.out.println("Transaction Added: " + split);
    }

    public void printUserBalance(String userId) {
        for (User user : balanceSheet.keySet()) {
            if (user.getId().equals(userId)) {
                double balance = balanceSheet.get(user);
                if (balance > 0) {
                    System.out.println(user.getName() + " is owed: " + balance);
                } else if (balance < 0) {
                    System.out.println(user.getName() + " owes: " + (-balance));
                } else {
                    System.out.println(user.getName() + " has no balance.");
                }
                return;
            }
        }
        System.out.println("User ID not found.");
    }

    public void printAllBalances() {
        for (Map.Entry<User, Double> entry : balanceSheet.entrySet()) {
            String name = entry.getKey().getName();
            double balance = entry.getValue();
            if (balance != 0.0) {
                System.out.println(name + (balance > 0 ? " is owed " : " owes ") + Math.abs(balance));
            }
        }
    }
}
