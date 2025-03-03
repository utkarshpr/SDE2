package sorting;

public class SelectionSort {
    public static void main(String args[]) {

        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        selection_sort(arr, n);
    }

    private static void selection_sort(int[] arr, int n) {
        for(int i=0;i<arr.length;i++){
            int temp=i;
            for(int j=i+1;j<arr.length;j++){
                if (arr[temp]>arr[j]){
                    temp=j;
                }
            }
            //swap
            int t=arr[i];
            arr[i]=arr[temp];
            arr[temp]=t;
        }
        System.out.println("After selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
