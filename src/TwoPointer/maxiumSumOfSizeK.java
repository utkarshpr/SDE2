package TwoPointer;

import java.util.Arrays;

public class maxiumSumOfSizeK {
    public static void main(String[] args) {
        // Test case 1: General case
        int[] arr1 = {100, 200, 400, 500};
        testCalculateMaxSum(arr1, 2, 900);

        // Test case 2: Array length == k
        int[] arr2 = {5, 1, 3, 7};
        testCalculateMaxSum(arr2, 4, 16);

        // Test case 3: All negative numbers
        int[] arr3 = {-10, -20, -30, -40};
        testCalculateMaxSum(arr3, 2, -30);

        // Test case 4: Mixed positive and negative numbers
        int[] arr4 = {1, -2, 3, -4, 5};
        testCalculateMaxSum(arr4, 3, 4); // {3, -4, 5} gives max sum 4

        // Test case 5: Single element, k=1
        int[] arr5 = {10};
        testCalculateMaxSum(arr5, 1, 10);

        // Test case 6: k > array length (invalid case, should return MIN_VALUE)
        int[] arr6 = {2, 3};
        testCalculateMaxSum(arr6, 5, Integer.MIN_VALUE);
    }

    private static void testCalculateMaxSum(int[] arr, int k, int expected) {
        int result = calculateMaxSum(arr, k);
        System.out.println("Array: " + Arrays.toString(arr) + ", k: " + k);
        System.out.println("Expected: " + expected + ", Actual: " + result);
        System.out.println(result == expected ? "✅ Test Passed!" : "❌ Test Failed!");
        System.out.println();
    }

    private static int calculateMaxSum(int[] ar, int k) {
        if (ar.length < k) return Integer.MIN_VALUE; // Handle invalid case

        int i = 0, j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while (j < ar.length) {
            sum += ar[j++];

            if (j - i == k) {
                max = Math.max(max, sum);
            } else if (j - i > k) {
                sum -= ar[i++];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
