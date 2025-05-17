package DP.SubsetSum;

import java.util.Arrays;

public class RodCutting {
    public static void main(String args[]) {
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack(n, W, val, wt));
    }

    private static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {
        int dp[][]=new int[n][w+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return knapsackUtil(wt, val, n - 1, w, dp);
    }

    private static int knapsackUtil(int[] wt, int[] val, int i, int w, int[][] dp) {
        if(i==0)
        {
            return ((w/wt[i])*val[i]);
        }
        if(dp[i][w]!=-1)return dp[i][w];
        int nontaken=knapsackUtil(wt,val,i-1,w,dp);
        int taken = Integer.MIN_VALUE;
        if (wt[i] <= w)
            taken = val[i] + knapsackUtil(wt, val, i, w - wt[i], dp);
        return  dp[i][w]=Math.max(nontaken,taken);
    }
}
