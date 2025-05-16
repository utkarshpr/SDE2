package DP.SubsetSum;

import java.util.*;

public class PartitionSetInto2SubsetsWithMinAbsoluteSumDiff {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int n = arr.size();

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));
    }

    private static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        boolean[][] dp = new boolean[n][totSum + 1];

        for (int i = 0; i <= totSum; i++) {
            dp[0][i] = (i == arr.get(0));
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= totSum; target++) {
                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }

                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
}
