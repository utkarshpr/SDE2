package Array.Easy;

import java.util.*;

public class LongestGivenSumK {
    public static void main(String[] args) {
            int[] a = {-1,1,1};
            long k = 1;
            int len = getLongestSubarray(a, k);
            System.out.println("The length of the longest subarray is: " + len);
    }

    private static int getLongestSubarray(int[] a, long k) {
        HashMap<Long,Integer> hm=new HashMap<>();
        long sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(sum == k){
                max=Math.max(max,i+1);
            }
            long rem=k-sum;
            if(hm.containsKey(rem)){
                int len=i-hm.get(rem);
                max=Math.max(max,len);
            }
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
        }
        return max;
    }
}
