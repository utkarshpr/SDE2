package Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergingIntervals {
    public static void main(String[] args) {
        runTest(new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}}, new int[][]{{1, 6}, {8, 10}, {15, 18}});
        runTest(new int[][]{{1, 4}, {4, 5}}, new int[][]{{1, 5}});
        runTest(new int[][]{{1, 4}, {2, 3}}, new int[][]{{1, 4}});
        runTest(new int[][]{{6, 8}, {1, 9}, {2, 4}, {4, 7}}, new int[][]{{1, 9}});
        runTest(new int[][]{{1, 10}, {2, 6}, {8, 10}}, new int[][]{{1, 10}});
        runTest(new int[][]{{1, 5}}, new int[][]{{1, 5}}); // Single interval
        runTest(new int[][]{}, new int[][]{}); // Empty case
        runTest(new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 2}, {3, 4}}); // Non-overlapping intervals
    }

    private static void runTest(int[][] input, int[][] expected) {
        List<List<Integer>> result = mergeOverlappingIntervals(input);
        System.out.println("Input: " + Arrays.deepToString(input));
        System.out.println("Expected: " + expectedToString(expected));
        System.out.println("Actual:   " + result);
        System.out.println(result.equals(convertToList(expected)) ? "✅ Test Passed!\n" : "❌ Test Failed!\n");
    }
    private static String expectedToString(int[][] expected) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] interval : expected) {
            sb.append("[").append(interval[0]).append(", ").append(interval[1]).append("], ");
        }
        return sb.length() > 1 ? sb.substring(0, sb.length() - 2) + "]" : "[]";
    }

    private static List<List<Integer>> convertToList(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] interval : arr) {
            list.add(Arrays.asList(interval[0], interval[1]));
        }
        return list;
    }

    private static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1)<arr[i][0]){
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }else{
                ans.get(ans.size() - 1).set(1,Math.max(ans.get(ans.size()-1).get(1),arr[i][1]));
            }
        }
        return ans;
    }
}
