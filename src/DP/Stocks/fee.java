package DP.Stocks;

import java.util.Arrays;

public class fee {

    public static void main(String args[]) {
        int prices[] = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println("The maximum profit that can be generated is " + stockProfit(prices,fee));
    }

    private static int stockProfit(int[] Arr,int fee) {
        int dp[][]=new int[Arr.length][3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = getAnscool(Arr, 0, 0, Arr.length, dp,fee);
        return ans;
    }

    private static int getAnscool(int[] arr, int i, int buy, int length, int[][] dp,int fee) {
        if(i==length)
            return 0;
        if(dp[i][buy]!=-1)return dp[i][buy];
        int profit=0;
        if(buy == 0){
            profit=Math.max(getAnscool(arr,i+1,0,length,dp,fee),
                    -arr[i]+getAnscool(arr,i+1,1,length,dp,fee));
        }
        else if(buy==1){
            profit=Math.max(getAnscool(arr,i+1,1,length,dp,fee),
                    arr[i]-fee+getAnscool(arr,i+1,0,length,dp,fee));//onl change
        }
        dp[i][buy]=profit;
        return profit;
    }
}
