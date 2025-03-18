package Recursion.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SUbsetSum {
    public static void main(String[] args) {
        runTest(new ArrayList<>(Arrays.asList(3, 1, 2)), Arrays.asList(0, 1, 2, 3, 3, 4, 5, 6));
        runTest(new ArrayList<>(Arrays.asList(5, 2)), Arrays.asList(0, 2, 5, 7));
        runTest(new ArrayList<>(Arrays.asList(1, 2, 3, 4)), Arrays.asList(0, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10));
        runTest(new ArrayList<>(Arrays.asList(10)), Arrays.asList(0, 10));
        runTest(new ArrayList<>(Arrays.asList(0, 0, 0)), Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
        runTest(new ArrayList<>(Arrays.asList()), Arrays.asList(0));  // Edge case: Empty input
    }

    private static void runTest(ArrayList<Integer> arr, List<Integer> expected) {
        ArrayList<Integer> result = subsetSums(arr, arr.size());
        Collections.sort(result);
        System.out.println("Array: " + arr);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result.equals(expected) ? "✅ Test Passed!\n" : "❌ Test Failed!\n");
    }

    private static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int size) {
        ArrayList< Integer > ans=new ArrayList<>();
        helperF(arr,size,0,ans,0);
        return  ans;
    }

    private static void helperF(ArrayList<Integer> arr, int size, int i, ArrayList<Integer> ans, int isum) {
        if(i==arr.size()){
            ans.add(isum);
            return;
        }
        helperF(arr,size,i+1,ans,isum+arr.get(i));
        helperF(arr,size,i+1,ans,isum);
    }
}
