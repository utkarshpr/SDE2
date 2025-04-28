package DP.oneD;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n=10;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
       fib(n,dp);
       System.out.println(dp[dp.length-1]);

       dp[0]=0;
       dp[1]=1;
       TabulatopnFibo(dp,n);

    }



    /*
    Reurssion
    Top down
    Answer -> Base
     */
    private static int fib(int n, int[] dp) {
        // TC O(n)  SC => O(n)+O(n)
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1) return dp[n];
        return  dp[n]=fib(n-1,dp)+fib(n-2,dp);
    }
    // 0 1 1 2 3 5 8 13 21 34

    /*
    Tabulation
    Bottom up

    Base case to required answer
     */
    private static void TabulatopnFibo(int[] dp, int n) {
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
