package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumofAllSubArray {
    public static void main(String[] args) {
        // Test Case 1: Mixed positive and negative numbers
        test(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new Integer[]{3, 3, 5, 5, 6, 7});

        // Test Case 2: Large input with increasing and decreasing order
        test(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, 4, new Integer[]{40, 50, 60, 70, 80, 90, 100});

        // Test Case 3: All negative numbers
        test(new int[]{-5, -10, -15, -20, -25}, 2, new Integer[]{-5, -10, -15, -20});

        // Test Case 4: All positive numbers
        test(new int[]{5, 10, 15, 20, 25}, 3, new Integer[]{15, 20, 25});

        // Test Case 5: Single element in array
        test(new int[]{42}, 1, new Integer[]{42});

        // Test Case 6: Window size equals array length
        test(new int[]{4, 2, 7, 1, 9, 3, 6}, 7, new Integer[]{9});

        // Test Case 7: Window size larger than array length (Edge Case)
        test(new int[]{8, 3, 5}, 5, new Integer[]{}); // Expect empty list since window size is greater

        // Test Case 8: Repeated values
        test(new int[]{4, 4, 4, 4, 4, 4, 4}, 3, new Integer[]{4, 4, 4, 4, 4});
    }

    private static void test(int[] A, int B, Integer[] expected) {
        Object[] result = calculateMaxNumber(A, B);
        System.out.println("Array: " + Arrays.toString(A) + ", Window Size: " + B);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual:   " + Arrays.toString(result));
        System.out.println(Arrays.equals(result, expected) ? "✅ Test Passed!" : "❌ Test Failed!");
        System.out.println();
    }

    private static Object[] calculateMaxNumber(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (j < A.length) {
            pq.add(A[j]);
            if (j - i + 1 < B) {

            } else if (j - i + 1 == B) {
                ans.add(pq.peek());
            } else {
                if (pq.peek() == A[i]) {
                    pq.poll();
                }
                i++;
                if (j - i + 1 == B) {
                    ans.add(pq.peek());

                }

            }
            j++;

        }
        return ans.toArray();
    }
}
