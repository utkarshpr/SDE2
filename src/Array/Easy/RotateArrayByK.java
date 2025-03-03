package Array.Easy;

public class RotateArrayByK {
    public static void main(String args[]) {
        int n=5;

        int arr[]= {1,2,3,4,5,6,7};
        solveleft(arr, n,2);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int arr1[]= {1,2,3,4,5,6,7};
        solveright(arr1, n,2);

        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
    }

    private static void solveright(int[] arr1, int n, int i) {
       solveleft(arr1,n,arr1.length-i);
    }

    private static void solveleft(int[] arr, int n,int k) {
        rotate(arr,0,k-1);
        rotate(arr,k,arr.length-1);
        rotate(arr,0,arr.length-1);
    }
    private static void rotate(int arr[],int l,int h){
        for(int i=l;i<=h;i++){
            int temp=arr[i];
            arr[i]=arr[h];
            arr[h]=temp;
            h--;
        }
    }
}
