package DP.Stocks;

import java.util.Arrays;

public class BuyANDSell_AS_MANY {
    public static void main(String[] args) {
        int n = 6;
        long[] Arr = {7, 1, 5, 3, 6, 4};

        System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
        System.out.println("The maximum profit that can be generated is " + getMaximumProfittabulation(Arr, n));
    }

    private static long getMaximumProfittabulation(long[] arr, int n) {
        long[][] dp = new long[n + 1][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[n][0] = dp[n][1] = 0;

        long profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], arr[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }

    private static long getMaximumProfit(long[] arr, int n) {
        long[][] dp = new long[n][2];
        for (long[] row : dp) Arrays.fill(row, -1);
        return utisls(arr,n,0,0,dp);
    }

    private static long utisls(long[] arr, int n, int i,int buy,long [][]dp) {
        //base
        if (i == n)
            return 0;
        if (dp[i][buy] != -1)
            return dp[i][buy];
        long profit = 0;
        if(buy==0){
            long nonpick= utisls(arr, n, i +1, 0,dp);
            long pic =-arr[i]+utisls(arr,n,i+1,1,dp);
            profit=Math.max(nonpick,pic);

        }
        if (buy == 1) {
            long nonpick= utisls(arr, n, i + 1, 1,dp);
            long pic =arr[i]+utisls(arr,n,i+1,0,dp);
            profit=Math.max(nonpick,pic);
        }
        dp[i][buy] = profit;
        return profit;
    }

}
