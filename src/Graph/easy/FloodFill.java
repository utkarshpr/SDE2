package Graph.easy;

import java.util.ArrayList;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        // sr = 1, sc = 1, newColor = 2
        int[][] ans = objfloodFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    private static int[][] objfloodFill(int[][] image, int sr, int sc, int newColor) {
       int ans[][]=image;
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        dfsFlood(image,ans,sr,sc,newColor,image[sr][sc],delRow,delCol);
        return ans;
    }

    private static void dfsFlood(int[][] image, int[][] ans, int sr, int sc, int newColor, int intColor,int [] delRow,int [] delCol) {
        ans[sr][sc]=newColor;
        for(int i=0;i<4;i++){
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];

            if(nrow>=0 && ncol>=0 && nrow<image.length && ncol< image[0].length
               && image[nrow][ncol]==intColor && ans[nrow][ncol]!=newColor){
                ans[nrow][ncol]=newColor;
                dfsFlood(image,ans,nrow,ncol,newColor,intColor,delRow,delCol);
            }
        }

    }
}
