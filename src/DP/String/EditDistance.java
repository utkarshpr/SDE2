package DP.String;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: " +
                editDistance(s1, s2));

        System.out.println("The minimum number of operations required is: " +
                editDistancetabula(s1, s2));
    }

    private static int editDistancetabula(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]  ;
                } else {
                    dp[i][j] =1+ Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }

    static int editDistance(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int[][] dp = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return editDistanceUtil(S1, S2, n - 1, m - 1, dp);
    }

    private static int editDistanceUtil(String s1, String s2, int n, int m, int[][] dp) {
        if (n < 0)
            return m + 1;
        if (m < 0)
            return n + 1;
        if(s1.charAt(n)==s2.charAt(m)){
           return editDistanceUtil(s1,s2,n-1,m-1,dp);
        }
        else{
           return 1+ Math.min(editDistanceUtil(s1,s2,n-1,m,dp),Math.min(editDistanceUtil(s1,s2,n-1,m-1,dp),editDistanceUtil(s1,s2,n,m-1,dp)));
        }
    }

}
