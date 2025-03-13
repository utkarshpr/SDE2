package Array.Medium;

import java.util.Arrays;

public class LongestConsecutiveNumber {
    public static void main(String[] args) {
//        int[] a = {100, 200, 1, 2, 3, 4};
//        int ans = longestSuccessiveElements(a);
//        System.out.println("The longest consecutive sequence is " + ans);
        testLongestConsecutiveElements();
    }

    private static void testLongestConsecutiveElements() {
        int[][] testCases = {
                {100, 200, 1, 2, 3, 4},
                {1, 9, 3, 10, 4, 20, 2},
                {10, 11, 12, 13, 14, 15},
                {5, 5, 5, 5, 5},
                {0, -1, -2, -3, -4},
                {7, 6, 5, 8, 9, 10},
                {50, 3, 2, 1, 4, 5, 100, 101, 102},
                {}
        };

        int[] expectedResults = {4, 4, 6, 1, 5, 6, 5, 0};

        for (int i = 0; i < testCases.length; i++) {
            int result = longestSuccessiveElements(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": Expected " + expectedResults[i] + ", Got " + result);
            assert result == expectedResults[i] : "Test case failed!";
        }
    }
    private static int longestSuccessiveElements(int[] a) {
        int cnt=0;
        Arrays.sort(a);
        int max=Integer.MIN_VALUE;
        int prev=0;
        for(int i=0;i<a.length;i++){
            if (i!=0 ){
                if (a[i]==a[i-1]+1){
                    cnt++;
                }
                else{
                    max=Math.max(max,cnt);
                    cnt=0;
                }
            }
            max=Math.max(max,cnt);

        }
        return max==Integer.MIN_VALUE?0:max+1;
    }
}
