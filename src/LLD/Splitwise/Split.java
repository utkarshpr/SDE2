package LLD.Splitwise;


import java.util.List;

public class Split {
    private User paidBy;
    private double amount;
    private List<User> borrowedUsers;
    private Strategy strategy;

    public Split(User paidBy, double amount, List<User> borrowedUsers, Strategy strategy) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.borrowedUsers = borrowedUsers;
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "Split{paidBy=" + paidBy.getName() +
                ", amount=" + amount +
                ", borrowedUsers=" + borrowedUsers.stream().map(User::getName).toList() +
                ", strategy=" + strategy.getClass().getSimpleName() + '}';
    }
}
