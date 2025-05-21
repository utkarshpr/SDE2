package LLD.Splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements Strategy {


    @Override
    public Map<User, Double> splitAmount(User paidBy, double totalAmount, List<User> borrowedUsers) {
        Map<User, Double> map = new HashMap<>();
        double perUser = totalAmount / borrowedUsers.size();

        for (User user : borrowedUsers) {
            map.put(user, perUser);
        }
        return map;
    }
}