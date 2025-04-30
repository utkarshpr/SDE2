package DP.oneD;

import java.util.Arrays;

public class NoTwoElementSum {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,3,5,8,1,9};
        int n = arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int result = memoizationNoTwoElementSum(n-1, arr,dp);
        System.out.println(result+" "+dp[n-1]);

        /*
        tabulation
         */
        TabulationNoTwoElementSum(n-1, arr,dp);

    }

    private static void TabulationNoTwoElementSum(int n, int[] arr, int[] dp) {
        dp[0]=arr[0];
        for(int i=1;i<=n;i++){
            int pic=arr[i];
            if(i>1){
                pic+=dp[i-2];
            }
            int nonpick=dp[i-1];
            dp[i]=Math.max(pic,nonpick);
        }
        System.out.println(dp[n]);
    }

    private static int memoizationNoTwoElementSum(int n, int[] arr,int[] dp) {

        if(n<0){
            return 0;
        }
        if(dp[n]!=-1) return dp[n];
        int nonskip=arr[n]+memoizationNoTwoElementSum(n-2,arr,dp);
        int skip= memoizationNoTwoElementSum(n - 1, arr,dp);
        return dp[n]= Math.max(nonskip,skip);
    }
}
