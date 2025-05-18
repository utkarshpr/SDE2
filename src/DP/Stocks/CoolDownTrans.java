package DP.Stocks;

import java.util.Arrays;

public class CoolDownTrans {
    public static void main(String args[]) {
        int prices[] = {4, 9, 0, 4, 10};

        System.out.println("The maximum profit that can be generated is " + stockProfit(prices));
    }

    private static int stockProfit(int[] Arr) {
        int dp[][]=new int[Arr.length][3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = getAnscool(Arr, 0, 0, Arr.length, dp);
        return ans;
    }

    private static int getAnscool(int[] arr, int i, int buy, int length, int[][] dp) {
        if(i>=length)
            return 0;
        if(dp[i][buy]!=-1)return dp[i][buy];
        int profit=0;
        if(buy == 0){
            profit=Math.max(getAnscool(arr,i+1,0,length,dp),
                    -arr[i]+getAnscool(arr,i+1,1,length,dp));
        }
        else if(buy==1){
            profit=Math.max(getAnscool(arr,i+1,1,length,dp),
                    arr[i]+getAnscool(arr,i+2,0,length,dp));//onl change
        }
        dp[i][buy]=profit;
        return profit;
    }
}
