package StackANDQueue;

import java.util.Stack;

public class SumOfSubarrayMin {
    public static void main(String[] args) {
        int[] ar = {3, 1, 2, 4};
        int[] nse = nextSmallerIndices(ar);   // Next Smaller Element indices
        int[] pse = prevSmallerIndices(ar);   // Previous Smaller Element indices

        int total = 0;
        int mod = (int)1e9 + 7;

        for (int i = 0; i < ar.length; i++) {
            int left = i - pse[i];            // Distance to previous smaller
            int right = nse[i] - i;           // Distance to next smaller
            total = (total + (ar[i] * left * right) % mod) % mod;
        }

        System.out.println("Sum of subarray minimums = " + total);
    }

    // Next Smaller Element (Right)
    public static int[] nextSmallerIndices(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? n : stack.peek(); // Use 'n' instead of -1
            stack.push(i);
        }
        return result;
    }

    // Previous Smaller Element (Left)
    public static int[] prevSmallerIndices(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }
}