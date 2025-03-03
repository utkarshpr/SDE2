package Array.Easy;

public class MoveAllZeroToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int n = 10;
        int[] ans = moveZeros(n, arr);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("");
    }

    private static int[] moveZeros(int n, int[] arr) {
       if (n<2){
           return  arr;
       }
       int i=0,j=-1;
       for(int x=0;x<arr.length;x++){
           if(arr[x]==0){
               j=x;
               i=x;
               break;
           }
       }
       if(j==-1){
           return arr;
       }
       for(int x=i;x<arr.length;x++){
           if(arr[x]!=0){
               int temp=arr[x];
               arr[x]=arr[j];
               arr[j]=temp;
               j++;
           }
       }
       return arr;
    }

}
