package DP.oneD;

import java.util.Arrays;

public class FrogJump1 {
    public static void main(String[] args) {
        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
       int ans= memoizaFrogJump1(n-1,height,dp);
       System.out.println(ans+" "+dp[n-1]);

       tabulaFrogJump1(dp,height,n);
    }

    private static void tabulaFrogJump1(int[] dp, int[] height, int n) {
        dp[0]=0;
        for(int i=1;i<n;i++){
            int onejump=dp[i-1]+Math.abs(height[i]-height[i-1]);
            int twojump=Integer.MAX_VALUE;
            if(i>1)
                twojump=dp[i-2]+Math.abs(height[i]-height[i-2]);
            dp[i]=Math.min(onejump,twojump);
        }
        System.out.println(dp[n-1]);
    }

    private static int memoizaFrogJump1(int n, int[] height, int[] dp) {
        if(n==0)
            return 0;
        int onejump=memoizaFrogJump1(n-1,height,dp)+Math.abs(height[n]-height[n-1]);
        int twojump=Integer.MAX_VALUE;
        if(n>1)
            twojump=memoizaFrogJump1(n-2,height,dp)+Math.abs(height[n]-height[n-2]);
        if(dp[n]!=-1)return dp[n];
        return dp[n]=Math.min(onejump,twojump);
    }


}
