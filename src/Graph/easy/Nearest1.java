package Graph.easy;

import java.util.*;

public class Nearest1 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };

        int[][] ans = objnearest(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] objnearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // visited and distance matrix
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        // <coordinates, steps>
        Queue<Node> q = new LinkedList<Node>();
        // traverse the matrix
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // start BFS if cell contains 1
                if(grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
                else {
                    // mark unvisted
                    vis[i][j] = 0;
                }
            }
        }



        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        while(!q.isEmpty()){
           Node node =q.poll();
           int row=node.x;
           int col=node.y;
           int count=node.count;
           dist[row][col]=count;
           for(int i=0;i<4;i++){
               int nrow = row + delrow[i];
               int ncol = col + delcol[i];
               if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && vis[nrow][ncol]!=1){
                   vis[nrow][ncol]=1;
                   q.add(new Node(nrow,ncol,count+1));
               }
           }
        }
    return  dist;
    }
}
class Node{
    int x;
    int y;
    int count;
    Node(int x,int y,int count){
        this.x=x;
        this.y=y;
        this.count=count;
    }
}
