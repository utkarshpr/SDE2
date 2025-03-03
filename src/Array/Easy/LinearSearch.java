package Array.Easy;

import java.util.HashMap;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int num = 40;
        int n = arr.length;
        int val = searchnum(arr,n,num);
        System.out.println(val);
    }
    public static int searchnum(int ar[],int n,int k){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<ar.length;i++){
            hm.put(ar[i],i);
        }
        return hm.getOrDefault(k,-1);
    }
}
