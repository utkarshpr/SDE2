package Recursion.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Array.Hard.CombinationSum.combinationSum;

public class CombinationSum {
    public static void main(String[] args) {
        runTest(new int[]{2, 3, 6, 7}, 7, Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(7)
        ));

        runTest(new int[]{2, 3, 5}, 8, Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5)
        ));

        runTest(new int[]{2}, 1, Arrays.asList()); // No valid combination

        runTest(new int[]{1}, 2, Arrays.asList(
                Arrays.asList(1, 1)
        ));

        runTest(new int[]{8, 10}, 7, Arrays.asList()); // No valid combination

        runTest(new int[]{1}, 1, Arrays.asList(
                Arrays.asList(1)
        ));

        runTest(new int[]{2, 4, 6, 8}, 8, Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 2, 4),
                Arrays.asList(2, 6),
                Arrays.asList(4, 4),
                Arrays.asList(8)
        ));
    }

    private static void runTest(int[] arr, int target, List<List<Integer>> expected) {
        List<List<Integer>> result = solcombinationSum(arr, target);
        System.out.println("Array: " + Arrays.toString(arr) + ", Target: " + target);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result.equals(expected) ? "✅ Test Passed!\n" : "❌ Test Failed!\n");
    }

    private static List<List<Integer>> solcombinationSum(int[] arr, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(ans,arr,target,temp,0);
        return ans;
    }

    private static void helper(List<List<Integer>> ans, int[] arr, int target, List<Integer> temp, int i) {
        if( i== arr.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr[i]<=target){
            temp.add(arr[i]);
            helper(ans,arr,target-arr[i],temp,i);
            temp.remove(temp.size()-1);
        }
        helper(ans,arr,target,temp,i+1);
    }
}
