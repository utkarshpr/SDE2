package DP.LIS;

import java.util.Arrays;

public class NoOfLIS {
    public static void main(String args[]) {

        int[] arr = {1,5,4,3,2,6,7,2};

        System.out.println("The count of LIS is "+findNumberOfLIS(arr));

    }

    private static int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int ct[]=new int[n];
        Arrays.fill(ct,1);
        int maxi=1;
        for(int i=0;i<n;i++) {
            for (int j = 0; j <=i - 1; j++) {
                if (arr[i] > arr[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    ct[i] = ct[j];
                } else if (arr[i] > arr[j] && dp[i] == 1 + dp[j]) {
                    ct[i] = ct[i] + ct[j];
                }
            }

            maxi = Math.max(maxi, dp[i]);
        }
        int nos =0;

        for(int i=0; i<=n-1; i++){
            if(dp[i]==maxi) nos+=ct[i];
        }

        return nos;
    }
}
