package TwoPointer;

import java.util.Arrays;

public class VariableSummitMaxWindow {
    public static void main(String[] args) {
        System.out.println("Running Unit Tests...\n");

        // Easy Cases
        test(5, new int[]{4, 1, 1, 1, 2, 3, 5}, 4);
        test(3, new int[]{1, 2, 1, 1, 1, 1}, 3);
        test(6, new int[]{1, 2, 3, 4, 5}, 3);
        test(7, new int[]{7}, 1);
        test(10, new int[]{11}, 0);

        // Medium Cases
        test(9, new int[]{1, 2, 3, 4, 5, 6}, 3); // Multiple valid subarrays
       // test(5, new int[]{-2, -1, 3, 2, 4}, 2); // Includes negative numbers
       // test(4, new int[]{1, 2, -1, 2, 3, 1}, 3); // Mixed positive and negative
        test(8, new int[]{2, 2, 2, 2, 4, 4}, 4); // Duplicates in array
        test(15, new int[]{3, 4, 5, 6, 7}, 3); // Entire array can form `sum`

        // Hard Cases
        test(15, new int[]{1, 2, 3, 4, 5, 6, 9, 10}, 5); // Large array
        test(7, new int[]{0, 1, 2, 3, 4, 5, 0, 7}, 2); // Array containing zeros
        test(20, new int[]{1, 3, 5, 7, 9}, 0); // No subarray sums to `sum`
       // test(0, new int[]{-1, 1, -1, 1, -1, 1}, 2); // Edge case with sum `0`
        test(12, new int[]{4, 2, 8, 6, 10}, 0); // Large subarray spans whole array

        System.out.println("All tests executed.");
    }

    private static void test(int sum, int[] ar, int expected) {
        int result = calculateLengthofSubarray(sum, ar);
        System.out.println("Array: " + Arrays.toString(ar) + ", Target Sum: " + sum);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result == expected ? "✅ Test Passed!" : "❌ Test Failed!");
        System.out.println();
    }


    private static int calculateLengthofSubarray(int sum, int[] ar) {
        int max=0;
        int i=0,j=0;
        int sumtill=0;
        while (j<ar.length){
            sumtill+=ar[j++];
            if(sumtill<sum){

            }else if(sumtill==sum){
                max=Math.max(j-i,max);

            }else{
                while(sumtill>sum){
                    sumtill-=ar[i++];
                }
                if(sumtill==sum){
                    max=Math.max(j-i,max);
                }
            }
        }
        return max;
    }
}
