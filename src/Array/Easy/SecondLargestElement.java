package Array.Easy;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        int n = arr.length;
        int sS = secondSmallest(arr, n);
        int sL = secondLargest(arr, n);
        System.out.println("Second smallest is "+sS);
        System.out.println("Second largest is "+sL);
    }

    private static int secondSmallest(int[] arr, int n) {
        return -1;
    }

    private static int secondLargest(int[] arr, int n) {
        if(n<2){
            return -1;
        }
        int large=Integer.MIN_VALUE;
        int secLarge=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>large){
                secLarge=large;
                large=arr[i];
            }
            else if (arr[i]<large && arr[i]>secLarge){
                secLarge=arr[i];
            }
        }
        return  secLarge;
    }
}
