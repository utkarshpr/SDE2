package StackANDQueue;

public class TrappingRainWaterr {
    public static void main(String args[]) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The duplicate element is " + trap(arr));
    }

    private static String trap(int[] arr) {
        int prefMax[]=new int[arr.length];
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
            prefMax[i]=max;
        }

        int Suffix[]=new int[arr.length];
         max=-1;
        for(int i=arr.length-1;i>=0;i--){
            if(max<arr[i]){
                max=arr[i];
            }
            Suffix[i]=max;
        }
        int total=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<Suffix[i] && arr[i]<prefMax[i]){
                total+=Math.min(Suffix[i],prefMax[i])-arr[i];
            }
        }

        return total+"";
    }

}
