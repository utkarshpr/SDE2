package DP.SubsetSum;

import java.util.Arrays;

public class SubsetSumEqualTARGET {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 5;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
        boolean xx=subsetSumToKTabulkation(n,k,arr);
                System.out.println(xx);
    }

    private static boolean subsetSumToKTabulkation(int n, int k, int[] arr) {
        boolean dp[][]=new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];
                 boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = notTaken || taken;
            }
        }

        return dp[n-1][k];

    }

    private static boolean subsetSumToK(int n, int k, int[] arr) {
        int dp[][] = new int[n][k + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return subsetSumToKUtils(n-1,arr,k,dp);
    }

    private static boolean subsetSumToKUtils(int n, int[] arr, int target,int dp[][]) {

        if(target ==0)
            return true;
        if(n==0)
            return (arr[0] == target);
        if(dp[n][target]!=-1)
        {
            System.out.println("Calculated value call");
            return dp[n][target] == 0 ? false : true;
        }
        boolean notTaken=subsetSumToKUtils(n-1,arr,target,dp);
        boolean taken=false;
         if(target>=arr[n]){
             taken=subsetSumToKUtils(n-1,arr,target-arr[n],dp);
         }
        dp[n][target] = notTaken || taken ? 1 : 0;
        return  notTaken || taken;
    }
}
