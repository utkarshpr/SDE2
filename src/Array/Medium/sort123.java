package Array.Medium;

import java.util.*;

public class sort123 {
    public static void main(String args[]) {
        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        sortArray(arr, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

    }

    private static void sortArray(ArrayList<Integer> arr, int n) {
        int low=0,high=n-1;
        int mid=0;
        while(mid<=high){
            if(arr.get(mid)==0){
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);
                low++;
                mid++;
            }
            else if(arr.get(mid)==1){
                mid++;
            }
            else{
                int temp = arr.get(high);
                arr.set(high, arr.get(mid));
                arr.set(mid, temp);
                high--;
            }

        }
    }
}
