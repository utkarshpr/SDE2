package DP.SubsetSum;

import java.util.Arrays;

public class CoinChange2 {


    public static void main(String[] args) {

        int arr[] = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
    }

    private static long countWaysToMakeChange(int[] arr, int n, int T) {
        long dp[][] = new long[n][T + 1];
        for (long row[] : dp)
            Arrays.fill(row, -1);
        return countWaysToMakeChangeutil(arr, n - 1, T, dp);
    }
    private  static long countWaysToMakeChangeutil(int []arr, int n, int T, long[][] dp){
        if(n==0){
            if(T%arr[n]!=1)
                return 1;
            else
                return 0;
        }
        if (dp[n][T] != -1)
            return dp[n][T];
        long notTaken = countWaysToMakeChangeutil(arr, n - 1, T, dp);
        long taken=0;
        if (arr[n] <= T)
            taken = countWaysToMakeChangeutil(arr, n, T - arr[n], dp);
       return  dp[n][T]=taken+notTaken;

    }
}
