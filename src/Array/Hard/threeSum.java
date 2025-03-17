package Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {

            System.out.println("Running Easy Test Cases:");
            runTest(new int[]{0, 1, -1}, Arrays.asList(
                    Arrays.asList(-1, 0, 1)
            )); // ✅ Easy: Small input with one triplet

            runTest(new int[]{-2, 0, 1, 1, 2}, Arrays.asList(
                    Arrays.asList(-2, 0, 2),
                    Arrays.asList(-2, 1, 1)
            )); // ✅ Easy: Contains duplicate numbers forming triplets

            runTest(new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(
                    Arrays.asList(-1, -1, 2),
                    Arrays.asList(-1, 0, 1)
            )); // ✅ Easy: Basic test case from LeetCode

            System.out.println("\nRunning Medium Test Cases:");
            runTest(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}, Arrays.asList(
                    Arrays.asList(-4, -2, 6),
                    Arrays.asList(-4, 0, 4),
                    Arrays.asList(-4, 1, 3),
                    Arrays.asList(-4, 2, 2),
                    Arrays.asList(-2, -2, 4),
                    Arrays.asList(-2, 0, 2)
            )); // ✅ Medium: Large set with multiple triplets

            runTest(new int[]{-5, -2, -1, 0, 1, 3, 5, 6}, Arrays.asList(
                    Arrays.asList(-5, -1, 6),
                    Arrays.asList(-5, 0, 5),
                    Arrays.asList(-2, -1, 3),
                    Arrays.asList(-1, 0, 1)
            )); // ✅ Medium: Various negative and positive numbers

            runTest(new int[]{0, 0, 0, 0}, Arrays.asList(
                    Arrays.asList(0, 0, 0)
            )); // ✅ Medium: All zeros, one valid triplet

            System.out.println("\nRunning Hard Test Cases:");
            runTest(new int[]{}, new ArrayList<>()); // ✅ Hard: Empty array, should return []

            runTest(new int[]{-1, -1, -1, -1}, new ArrayList<>()); // ✅ Hard: All negative numbers, no valid triplet

            runTest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new ArrayList<>()); // ✅ Hard: No zero-sum triplets possible

            runTest(new int[]{-10, -7, -3, -2, -1, 0, 1, 2, 3, 5, 7, 10}, Arrays.asList(
                    Arrays.asList(-10, 0, 10),
                    Arrays.asList(-10, 3, 7),
                    Arrays.asList(-7, -3, 10),
                    Arrays.asList(-7, 0, 7),
                    Arrays.asList(-7, 2, 5),
                    Arrays.asList(-3, -2, 5),
                    Arrays.asList(-3, 0, 3),
                    Arrays.asList(-2, -1, 3),
                    Arrays.asList(-2, 0, 2)
            )); // ✅ Hard: Large dataset with multiple complex triplets
        }

        private static void runTest(int[] arr, List<List<Integer>> expected) {
            List<List<Integer>> result = triplet(arr.length, arr);
            System.out.println("Array: " + Arrays.toString(arr));
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + result);
            System.out.println(result.equals(expected) ? "✅ Test Passed!" : "❌ Test Failed!");
            System.out.println();
        }

    private static List<List<Integer>> triplet(int n, int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){

            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum>0){
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    List<Integer>ar=new ArrayList<>();
                    ar.add(arr[i]);
                    ar.add(arr[j]);
                    ar.add(arr[k]);
                    ans.add(ar);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++; // Skip duplicate j values
                    while (j < k && arr[k] == arr[k + 1]) k--; // Skip duplicate k values
                }
            }

        }
        return ans;
    }
}
