package Array.Medium;

public class kadaneeAlgo {
    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }

    private static long maxSubarraySum(int[] arr, int n) {
        int sum=0;
        long maxi = Long.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(maxi <sum){
                maxi=sum;
            }
            if(sum<0)
                sum=0;
        }
        return maxi;
    }
}
