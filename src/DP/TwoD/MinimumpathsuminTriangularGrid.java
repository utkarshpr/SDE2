package DP.TwoD;

import java.util.Arrays;

public class MinimumpathsuminTriangularGrid {
    public static void main(String[] args) {
        int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

        int n = triangle.length;

        // Call the minimumPathSum function and print the result
        System.out.println(minimumPathSum(triangle, n));
    }

    private static int minimumPathSum(int[][] triangle, int n) {
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        //return minimumPathSumUtil(0, 0, triangle, n, dp);
        return minimumPathSumUtilTabulas(0,0,triangle,n,dp);
    }

    private static int minimumPathSumUtilTabulas(int i, int j, int[][] triangle, int n, int[][] dp) {
        for (int x = 0; x < n; x++) {
            dp[n - 1][x] = triangle[n - 1][x];
        }
        for(int xi=n-2;xi>=0;xi--){
            for(int yi=xi;yi>=0;yi--){
                int down=triangle[xi][yi]+dp[xi+1][yi];
                int daig=triangle[xi][yi]+dp[xi+1][yi+1];
                dp[xi][yi]=Math.min(down,daig);
            }
        }
        return dp[0][0];
    }

    private static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {
        if (dp[i][j]!=-1)return  dp[i][j];
        if(i==n-1)
            return triangle[i][j];
        int down=triangle[i][j]+minimumPathSumUtil(i+1,j,triangle,n,dp);
        int daig=triangle[i][j]+minimumPathSumUtil(i+1,j+1,triangle,n,dp);
        return dp[i][j]=Math.min(down,daig);
    }
}
