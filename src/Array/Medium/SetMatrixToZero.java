package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixToZero {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
//        int row[]=new int[m];
//        int col[]=new int [n];
        int col=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
                if(matrix.get(i).get(j)==0){
//                    row[i]=1;
//                    col[j]=1;
                    matrix.get(i).set(0,0);//matric[i][0]=0
                    if (j!=0){
                        matrix.get(0).set(j,0);//matrix[0,j]
                    }else{
                        col=0;
                    }
                }
            }
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++){
               if(matrix.get(i).get(j)!=0){
                   if(matrix.get(i).get(0)==0 ||matrix.get(0).get(j)==0){
                       matrix.get(i).set(j,0);
                   }
               }
            }
        }
        //3rd
        //1st row
        if(matrix.get(0).get(0)==0){
            for(int j=0;j<matrix.get(0).size();j++){
                matrix.get(0).set(j,0);
            }
        }
        if(col==0){
            for(int i=0;i<matrix.size();i++){
                matrix.get(i).set(0,0);
            }
        }
        return matrix;
    }
}
