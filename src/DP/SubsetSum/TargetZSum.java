package DP.SubsetSum;

import java.util.Arrays;

import static DP.SubsetSum.CountSubset.findWaysUtil;

public class TargetZSum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1 };
        int target = 3;

        int n = arr.length;

        System.out.println("The number of ways found is " + targetSum(n, target, arr));
    }
    static int targetSum(int n, int target, int[] arr) {
        int totSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }

        if (totSum - target < 0)
            return 0;
        if ((totSum - target) % 2 == 1)
            return 0;

        int s2 = (totSum - target) / 2;

        int dp[][] = new int[n][s2 + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return findWaysUtil(n - 1, s2, arr, dp);
    }
}
