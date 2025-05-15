package DP.oneD;

import java.util.*;

public class HouseRobber2 {
    public static void main(String[] args) {

        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(6);
        int n=arr.size();
        System.out.println(robStreet(n,arr));
    }

    private static long robStreet(int n, ArrayList<Integer> arr) {
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        if(n==1)
            return arr.get(0);

        for(int i=0; i<n; i++){

            if(i!=0) arr1.add(arr.get(i));
            if(i!=n-1) arr2.add(arr.get(i));
        }

        long ans1 = solve11(arr1);
        long ans2 = solve11(arr2);

        return Math.max(ans1,ans2);

    }

    private static long solve11(ArrayList<Integer> arr1) {
        int dp[]=new int[arr1.size()];
        Arrays.fill(dp,-1);
        dp[0]=arr1.get(0);
        for(int i=1;i<arr1.size();i++){
            int pick=arr1.get(i);
            if(i>1){
                pick+=dp[i-2];
            }
            int nonpick=dp[i-1];
            dp[i]=Math.max(pick,nonpick);
        }
        return dp[arr1.size()-1];
    }

}
