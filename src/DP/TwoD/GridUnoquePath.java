package DP.TwoD;

import java.util.Arrays;

public class GridUnoquePath {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        System.out.println(countWays(m, n));
    }

    private static int countWays(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysUtilTabulation(m-1,n-1,dp);
       // return countWaysUtil(m - 1, n - 1, dp);
    }

    private static int countWaysUtilTabulation(int m, int n, int[][] dp) {
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0)
                {
                    dp[i][j]=1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if(i>0){
                    up=dp[i-1][j];
                }
                if(j>0){
                    left=dp[i][j-1];
                }
                dp[i][j]=left+up;
            }
        }
        return dp[m][n];
    }

    private static int countWaysUtil(int m, int n, int[][] dp) {
        if(m==0&& n==0){
            return 1;
        }
        if(m<0 || n<0)
            return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        int up=countWaysUtil(m-1,n,dp);
        int lef=countWaysUtil(m,n-1,dp);

        return dp[m][n]=up+lef;
    }
}
