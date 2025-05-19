package DP.LIS;

import java.util.Arrays;

public class LIS {
    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));
        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequencetabul(arr, n));
    }

    private static int longestIncreasingSubsequencetabul(int[] arr, int n) {
        int dp[][]=new int[n+1][n+1];
        for(int ind=n-1;ind>=0;ind--){
            for(int prev=ind-1;prev>=-1;prev--){
                int non=dp[ind+1][prev+1];
                int take=0;
                if(prev==-1||arr[ind]>arr[prev]){
                    take=1+dp[ind+1][ind+1];
                }
                dp[ind][prev+1] = Math.max(non,take);
            }
        }
        return dp[0][0];
    }

    private static int longestIncreasingSubsequence(int[] arr, int n) {
        int dp[][] = new int[n][n + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return longestIncreasingSubsequenceutils(arr,n,0,dp,-1);
    }

    private static int longestIncreasingSubsequenceutils(int[] arr, int n, int i,int dp[][],int prevIndex) {
        if(i==n){
            return  0;
        }
        if(dp[i][prevIndex+1]!=-1)return  dp[i][prevIndex+1];
        int notTake= longestIncreasingSubsequenceutils(arr, n, i + 1, dp, prevIndex);
        int take = 0;
        if(prevIndex == -1 ||arr[i]>arr[prevIndex]){
            take=longestIncreasingSubsequenceutils(arr,n,i+1,dp,i)+1;
        }
        return  dp[i][prevIndex+1]=Math.max(notTake, take);
    }
}
