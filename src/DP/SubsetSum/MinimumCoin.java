package DP.SubsetSum;

import java.util.Arrays;

public class MinimumCoin {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int T = 7;

        System.out.println("The minimum number of coins required to form the target sum is " + minimumElements(arr, T));
    }

    private static int minimumElements(int[] arr, int T) {
        int n = arr.length;
        int[][] dp = new int[n][T + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);


        /*
        Tabulation
         */
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = i / arr[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = 0 + dp[ind - 1][target];
                int take = (int) Math.pow(10, 9);

                if (arr[ind] <= target)
                    take = 1 + dp[ind][target - arr[ind]];

                dp[ind][target] = Math.min(notTake, take);
            }
        }

        int ans = dp[n - 1][T];
        return ans;

//        int ans = minimumElementsUtil(arr, n - 1, T, dp);
//
//        if (ans >= (int) Math.pow(10, 9))
//            return -1;
//        return ans;
    }

    private static int minimumElementsUtil(int[] arr, int i, int t, int[][] dp) {
        if(i==0){
            if(t%arr[i]==0)
                return t/arr[i];
            else
                return(int) Math.pow(10,9);
        }
        if(dp[i][t]!=-1)return dp[i][t];
        int nonpick= minimumElementsUtil(arr, i - 1, t, dp);
        int pick=(int) Math.pow(10, 9);
        if(arr[i]<=t){
            pick=1+minimumElementsUtil(arr,i,t-arr[i],dp);
        }
        return  dp[i][t]=Math.min(pick,nonpick);
    }
}
