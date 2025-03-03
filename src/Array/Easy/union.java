package Array.Easy;

import java.util.ArrayList;
import java.util.HashSet;

public class union {
    public static void main(String[] args) {
        int n = 10, m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union)
            System.out.print(val+" ");
    }

    private static ArrayList<Integer> FindUnion(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> res=new ArrayList<>();
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
            res.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++)
        {
            if(hs.contains(arr2[i]) && !res.contains(arr2[i])){
                res.add(arr2[i]);
            }
            else if(!res.contains(arr2[i])){
                res.add(arr2[i]);
            }
        }
    return res;
    }

}
