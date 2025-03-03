package Array.Easy;

public class largestElementInArray {
    public static void main(String args[]) {

        int arr1[] =  {2,5,1,3,0};
        System.out.println("The Largest element in the array is: " + isort(arr1));

        int arr2[] =  {8,10,5,7,9};
        System.out.println("The Largest element in the array is: " + isort(arr2));
    }

    private static String isort(int[] arr1) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            if (arr1[i]>max){
                max=arr1[i];
            }
        }
        return max+"";
    }
}
