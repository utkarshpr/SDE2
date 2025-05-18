package DP.Stocks;

import java.util.Arrays;

public class KTransaction {

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
        int k = 2;

        System.out.println("The maximum profit that can be generated is " + maximumProfit(prices, n, k));
        System.out.println("The maximum profit that can be generated is " + maximumProfittabu(prices,k));
    }
    static int maximumProfit(int[] Arr,int n, int k) {
        int n1 = Arr.length;

        int[][][] dp = new int[n][2][k+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return getAns(Arr, n, 0, 0, k, dp);
    }
    static int maximumProfittabu(int[] prices,int k) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k+1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {

                    if (buy == 0) {
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap],
                                -prices[ind] + dp[ind + 1][1][cap]);
                    }

                    if (buy == 1) {
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }

        return dp[0][0][k];
    }

    private static int getAns(int[] Arr, int n, int ind, int buy, int cap, int[][][] dp) {

        if(ind==n || cap==0)
            return  0;

        if(dp[ind][buy][cap]!=-1)
            return dp[ind][buy][cap];
        int profit = 0;
        if(buy ==0){
            profit = Math.max(
                    -Arr[ind] + getAns(Arr, n,ind + 1, 1, cap, dp),  // Buy
                    getAns(Arr, n,ind + 1, 0, cap, dp)                 // Skip
            );
        }
        else if(buy==1){
            profit = Math.max(
                    Arr[ind] + getAns(Arr, n,ind + 1, 0, cap - 1, dp),  // Sell
                    getAns(Arr, n,ind + 1, 1, cap, dp)                     // Skip
            );
        }
        return profit;
    }
}
