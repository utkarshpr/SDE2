package DP.LIS;

import java.util.ArrayList;
import java.util.*;

public class LISTabulation {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " +
                longestIncreasingSubsequencett(arr, n));
    }

    private static int longestIncreasingSubsequencett(int[] arr, int n) {
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        Arrays.fill(hash,1);
        int last_index=0;
        int maxi=0;
        for(int i=0;i<dp.length;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(arr[i]>arr[prev] && dp[i]<1+dp[prev]){
                    dp[i]=dp[prev]+1;
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                last_index=i;
            }
        }
        List<Integer> lis=new ArrayList<>();
        lis.add(arr[last_index]);
        while(hash[last_index]!=last_index){
            last_index=hash[last_index];
            lis.add(arr[last_index]);
        }
        System.out.println(lis);

        return  maxi;
    }
}
