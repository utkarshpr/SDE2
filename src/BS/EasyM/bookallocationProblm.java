package BS.EasyM;

import java.util.*;

public class bookallocationProblm {
    public static void main(String[] args) {
        // Test Cases with expected answers
        List<int[]> testCases = Arrays.asList(
                new int[]{25, 46, 28, 49, 24},  // Example case
                new int[]{12, 34, 67, 90},      // Basic test case
                new int[]{10, 20, 30, 40},      // Evenly distributed books
                new int[]{5, 5, 5, 5, 5},       // Same number of pages
                new int[]{50, 10, 20, 30, 40},  // Random order
                new int[]{10, 5, 20, 30}        // Edge case
        );

        List<Integer> students = Arrays.asList(4, 2, 2, 3, 3, 2);
        List<Integer> expectedResults = Arrays.asList(71, 113, 60, 10, 60, 35);

        for (int i = 0; i < testCases.size(); i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int num : testCases.get(i)) arr.add(num);
            int ans = findPages(arr, arr.size(), students.get(i));

            // Validate result with ✅ or ❌
            String result = (ans == expectedResults.get(i)) ? "✅" : "❌";
            System.out.println("Test " + (i + 1) + ": Min pages = " + ans + " (Expected: " + expectedResults.get(i) + ") " + result);
        }
    }

    private static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m>n)
            return -1;
        int min=Collections.max(arr);
        int max=arr.stream().mapToInt(Integer::intValue).sum();
        while (min<=max){
            int mid=(min+max)/2;
            if(isPossiblebook(mid,arr,m)){
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        return min;
    }

    private static boolean isPossiblebook(int mid, ArrayList<Integer> arr, int m) {
        int count=1;
        int pgcount=0;
        for(int i=0;i<arr.size();i++){
            if(pgcount+arr.get(i)<=mid){
                pgcount+=arr.get(i);

            }else {
                count++;
                pgcount=arr.get(i);
            }
        }
        return count>m;
    }
}
