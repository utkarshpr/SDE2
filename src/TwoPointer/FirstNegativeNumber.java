package TwoPointer;

import java.util.*;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        // Test case 1: General case
        int[] arr1 = {-8, 2, 3, -6, 10};
       // testCalculateFirstNegative(arr1, 2, Arrays.asList(-8, 0, -6, -6));

        // Test case 2: All positive numbers
        int[] arr2 = {5, 1, 3, 7};
      //  testCalculateFirstNegative(arr2, 2, Arrays.asList(0, 0, 0));

        // Test case 3: All negative numbers
        int[] arr3 = {-1, -2, -3, -4};
      //  testCalculateFirstNegative(arr3, 2, Arrays.asList(-1, -2, -3));

        // Test case 4: k = 1 (Single element per window)
        int[] arr4 = {4, -1, 7, -3};
       // testCalculateFirstNegative(arr4, 1, Arrays.asList(0, -1, 0, -3));

        // Test case 5: k > array length (Invalid case, should return empty list)
        int[] arr5 = {2, 3};
        //testCalculateFirstNegative(arr5, 5, Collections.emptyList());

        // Test case 6: Only one negative number
        int[] arr6 = {5, 6, -7, 8, 9};
        testCalculateFirstNegative(arr6, 3, Arrays.asList(-7, -7, -7));
    }

    private static void testCalculateFirstNegative(int[] arr, int k, List<Integer> expected) {
        List<Integer> result = calculateFirstNegative(arr, k);
        System.out.println("Array: " + Arrays.toString(arr) + ", k: " + k);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result.equals(expected) ? "✅ Test Passed!" : "❌ Test Failed!");
        System.out.println();
    }

    private static List<Integer> calculateFirstNegative(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> temp = new LinkedList<>();
        int i = 0, j = 0;

        while (j < arr.length) {
            if (arr[j] < 0) temp.add(arr[j]);

            if (j - i + 1 == k) {
                if (temp.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(temp.peek());
                    if (arr[i] == temp.peek()) temp.poll();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
