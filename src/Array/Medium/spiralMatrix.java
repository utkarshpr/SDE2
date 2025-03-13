package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class spiralMatrix {
    public static void main(String[] args) {
        //Matrix initialization.
        int[][] mat =
                {{1, 2, 3, 4},
                 {5, 6, 7, 8},
                 {9, 10, 11, 12},
                 {13, 14, 15, 16}};

        List<Integer> ans = printSpiral(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
        // Test case 1: 4x4 matrix
        int[][] mat1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        testPrintSpiral(mat1, Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10));

        // Test case 2: 3x3 matrix
        int[][] mat2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        testPrintSpiral(mat2, Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));

        // Test case 3: 2x2 matrix
        int[][] mat3 = {
                {1, 2},
                {3, 4}
        };
        testPrintSpiral(mat3, Arrays.asList(1, 2, 4, 3));

        // Test case 4: 1x4 matrix (Single row)
        int[][] mat4 = {
                {1, 2, 3, 4}
        };
        testPrintSpiral(mat4, Arrays.asList(1, 2, 3, 4));

        // Test case 5: 4x1 matrix (Single column)
        int[][] mat5 = {
                {1},
                {2},
                {3},
                {4}
        };
        testPrintSpiral(mat5, Arrays.asList(1, 2, 3, 4));
    }
    private static void testPrintSpiral(int[][] matrix, List<Integer> expected) {
        List<Integer> result = printSpiral(matrix);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result.equals(expected) ? "✅ Test Passed!" : "❌ Test Failed!");
        System.out.println();
    }

    private static List<Integer> printSpiral(int[][] mat) {
        List<Integer> ans=new ArrayList<>();
        int top=0,left=0,right=mat[0].length-1,bottom=mat.length-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans.add(mat[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++)
                ans.add(mat[i][right]);
            right--;

            if(top<=bottom) {
                for (int j = right; j >= left; j--)
                    ans.add(mat[bottom][j]);
                bottom--;
            }
            if(left<=right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);

                left++;
            }

        }
        return ans;
    }
}
