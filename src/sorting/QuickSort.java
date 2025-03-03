package sorting;

import java.util.*;

public class QuickSort {
    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[] {4, 6, 0, 67, 7, 9, 8, 3});
        int n = arr.size();
        System.out.println("Before Using insertion Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        arr = SquickSort(arr);
        System.out.println("After insertion sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    private static List<Integer> SquickSort(List<Integer> arr) {
        quickSort(arr,0,arr.size()-1);
        return arr;
    }

    private static void quickSort(List<Integer> arr, int i, int j) {
        if(i<j){
            int pIndex=quick(arr,i,j);
            quickSort(arr,i,pIndex-1);
            quickSort(arr,pIndex+1,j);
        }
    }

    static int quick(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }

            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }


}
