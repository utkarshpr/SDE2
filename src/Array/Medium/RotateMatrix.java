package Array.Medium;

public class RotateMatrix {
    public static void main(String[] args) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotateb(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateb(int[][] arr) {
        // transpose the matrix
        for (int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
               int temp=0;
               temp=arr[i][j];
               arr[i][j]=arr[j][i];
               arr[j][i]=temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }
        return arr;
    }
}
