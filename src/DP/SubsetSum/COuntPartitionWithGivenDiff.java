package DP.SubsetSum;

import static DP.SubsetSum.CountSubset.findWays;

public class COuntPartitionWithGivenDiff {
    public static void main(String[] args) {
        int arr[] = {5,2,6,4};
        int n = arr.length;
        int d=3;

        System.out.println("The number of subsets found are " +countPartitions(n,d,arr));
    
    }

    private static int countPartitions(int n, int d, int[] arr) {
        int totSum = 0;
        for(int i=0; i<n;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-d <0 || (totSum-d)%2 ==1) return 0;

        return findWays(arr,(totSum-d)/2);
    }
}
