package DP.String;

import java.util.Arrays;

public class LCSubsequence {
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + lcs(s1, s2));
    }

    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n][m];
        int x=tabulation(s1,s2,n,m);
        return x;
//        for (int rows[] : dp)
//            Arrays.fill(rows, -1);
//        return lcsUtil(s1, s2, n - 1, m - 1, dp);
    }

    private static int tabulation(String s1, String s2, int n, int m) {
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=0;
        for(int i=0;i<=m;i++)
            dp[0][i]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return  dp[n][m];
    }

    private static int lcsUtil(String s1, String s2, int i, int j, int[][] dp) {
        if(i<0 ||j<0)
        {
           return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return 1 +lcsUtil(s1,s2,i-1,j-1,dp);
        }
        return dp[i][j]=Math.max(lcsUtil(s1, s2, i, j - 1, dp) , lcsUtil(s1, s2, i - 1, j, dp));
    }
}
