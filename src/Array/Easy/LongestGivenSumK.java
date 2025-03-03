package Array.Easy;

import java.util.*;

public class LongestGivenSumK {
    public static void main(String[] args) {
            int[] a = {10 ,5 ,2 ,7 ,1 ,-10};
            long k = 15;
            int len = getLongestSubarray(a, k);
            System.out.println("The length of the longest subarray is: " + len);
    }

    private static int getLongestSubarray(int[] a, long k) {
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < a.length; i++) {

            sum += a[i];


            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }


            long rem = sum - k;


            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }

        }
        return maxLen;
    }
}
