package DP.oneD;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n=4;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);

        int x=recurClimbingStairs(dp,n);
        System.out.println(dp[n] +" "+x);

        TabulClimbingStairs(dp,n);
    }

    private static void TabulClimbingStairs(int[] dp, int n) {
        dp[0]=dp[1]=1;
        for(int x=2;x<=n;x++){
            dp[x]=dp[x-1]+dp[x-2];
        }
        System.out.println(dp[n]);
    }

    /*
        Memoziation
     */
    private static int recurClimbingStairs(int[] dp, int n) {
        if(n<=1)
            return 1;
        if(dp[n]!=-1){
            return  dp[n];
        }
        return dp[n]=recurClimbingStairs(dp,n-1)+recurClimbingStairs(dp,n-2);
    }

}
