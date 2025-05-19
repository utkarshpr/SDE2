package DP.LIS;

import java.util.Arrays;

public class BitonicArray {
    public static void main(String[] args) {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;

        System.out.println("The length of the longest bitonic subsequence is " +
                longestBitonicSequence(arr, n));
    }

    private static int longestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        //incre
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(arr[i]>arr[prev]){
                    dp1[i] = Math.max(dp1[i], 1 + dp1[prev]);
                }
            }
        }
        //dec
        for(int i=n-1;i>=0;i--){
            for(int prev=n-1;prev>i;prev--){
                if(arr[i]>arr[prev]){
                    dp2[i] = Math.max(dp2[i], 1 + dp2[prev]);
                }
            }
        }
        int max=-1;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp1[i]+dp2[i]-1);
        }
        return  max;
    }
}
