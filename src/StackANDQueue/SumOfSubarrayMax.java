package StackANDQueue;


import java.util.Stack;

public class SumOfSubarrayMax {
    public static void main(String[] args) {
        int ar[] = {3, 1, 2, 4};
        int n = ar.length;

        int[] nextGreater = nextGreaterIndices(ar);
        int[] prevGreater = prevGreaterIndices(ar);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - prevGreater[i];
            int right = nextGreater[i] - i;
            sum += (long) ar[i] * left * right;
        }

        System.out.println("Sum of Subarray Maximums = " + sum);
    }

    public static int[] nextGreaterIndices(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores index

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int[] prevGreaterIndices(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores index

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }
}

