package LLD.Splitwise;


import java.util.*;

public interface Strategy {
    Map<User, Double> splitAmount(User paidBy, double totalAmount, List<User> borrowedUsers);
}
