package StackANDQueue;

import java.util.Stack;

public class CelebrityProblem {

    public static void main(String[] args) {
        int[][] M = {
                {0, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };

        int celebrity = findCelebrity(M, M.length);
        if (celebrity == -1) {
            System.out.println("No celebrity found.");
        } else {
            System.out.println("Celebrity is person: " + celebrity);
        }
    }

    public static int findCelebrity(int[][] M, int n) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all people into the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2: Eliminate non-celebrities
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (M[a][b] == 1) {
                // a knows b => a can't be celebrity
                stack.push(b);
            } else {
                // a doesn't know b => b can't be celebrity
                stack.push(a);
            }
        }

        // Step 3: Verify the remaining candidate
        if (stack.isEmpty()) return -1;

        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Celebrity should not know anyone, and everyone should know celebrity
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}
