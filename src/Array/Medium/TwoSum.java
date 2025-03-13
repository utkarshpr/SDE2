package Array.Medium;

import java.util.HashMap;

public class TwoSum {
    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        String ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 1: " + ans);
    }

    private static String twoSum(int n, int[] arr, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(target-arr[i])){
                int x1=hm.get(target-arr[i]);

                return arr[x1]+" :: "+arr[i];
            }
            else{
                hm.put(arr[i],i);
            }
        }
        return "";
    }
}
