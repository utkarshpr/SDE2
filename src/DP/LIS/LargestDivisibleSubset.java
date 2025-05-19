package DP.LIS;

import java.util.*;

public class LargestDivisibleSubset {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1, 16, 7, 8, 4);

        List<Integer> ans = divisibleSet(arr);

        System.out.print("The longest divisible subset elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    private static List<Integer> divisibleSet(List<Integer> arr) {
        int n=arr.size();
        Collections.sort(arr);
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 1));
        List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));

        int maxi=0,last_index=0;
        for(int i=0;i<n;i++){
            hash.set(i,i);
            for(int pr=0;pr<i;pr++){
                    if(arr.get(i)%arr.get(pr)==0 && dp.get(i)<1+dp.get(pr)){
                        dp.set(i,1+dp.get(pr));
                        hash.set(i,pr);
                    }
            }

            if(dp.get(i)>maxi){
                maxi=dp.get(i);
                last_index=i;
            }
        }

        ArrayList<Integer> ar=new ArrayList<>();
        ar.add(arr.get(last_index));
        while(hash.get(last_index)!=last_index){
            last_index=hash.get(last_index);
            ar.add(arr.get(last_index));
        }
        return ar;

    }


}
