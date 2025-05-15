package DP.TwoD;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points));
    }

    private static int ninjaTraining(int n, int[][] points) {
        int dp[][]=new int[points[0].length][points.length+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solveninjaTrainingTabulation(n,points,dp,n+1);
        ///return solveninjaTraining(n-1,points,3,dp);
    }

    private static int solveninjaTrainingTabulation(int n, int[][] points, int[][] dp, int iprev) {
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int i=1;i<n;i++){
            for(int last=0;last<4;last++){
                dp[i][last]=0;
                for(int task=0;task<=2;task++){
                   if(task!=last){
                       int activity=points[i][task]+dp[i-1][task];
                       dp[i][last]=Math.max(dp[i][last],activity);
                   }
                }
            }
        }
        return dp[n-1][3];
    }

    private static int solveninjaTraining(int day, int[][] points, int prev,int dp[][]) {
        if (dp[day][prev] != -1) return dp[day][prev];
        if(day==0){
            int maxi=0;
            for(int i=0;i<points[0].length;i++){
                if(prev!=i){
                    maxi=Math.max(maxi,points[day][i]);
                }
            }
            return dp[day][prev]=maxi;
        }
        int maxi=0;
        for(int i=0;i<points[0].length;i++){
            if(prev!=i){
               int activity=points[day][i]+solveninjaTraining(day-1,points,i,dp);
                maxi = Math.max(maxi, activity);
            }
        }
        return  dp[day][prev]=maxi;
    }
}
