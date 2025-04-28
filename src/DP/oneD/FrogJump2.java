package DP.oneD;

import java.util.Arrays;

public class FrogJump2 {
    public static void main(String[] args) {
        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(MemoFrogJump2(n - 1, height, dp, k));
        System.out.println(dp[n-1]);
        TabuFrogJump2(n - 1, height, dp, k);

    }

    private static void TabuFrogJump2(int i, int[] height, int[] dp, int k) {
        dp[0]=0;

        for(int j=1;j<=i;j++){
            int mmSteps = Integer.MAX_VALUE;
            for(int st=1;st<=k;st++){
                if(j-st>=0){
                    int jump=dp[j-st]+Math.abs(height[j]-height[j-st]);
                    mmSteps=Math.min(jump,mmSteps);
                }
            }
            dp[j]=mmSteps;
        }
        System.out.println(dp[dp.length-1]);
    }

    private static int MemoFrogJump2(int i, int[] height, int[] dp, int k) {
        if(i==0)
            return 0;
        int mmSteps = Integer.MAX_VALUE;
        if (dp[i]!=-1)return dp[i];
        for(int st=1;st<=k;st++){
            if(i-st>=0){
                int step=MemoFrogJump2(i-st,height,dp,k)+Math.abs(height[i]-height[i-st]);
                mmSteps=Math.min(step,mmSteps);
            }
        }
        return dp[i]=mmSteps;
    }

}
