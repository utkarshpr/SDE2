package Graph.easy;

import java.util.*;

public class island {
    public static void main(String[] args) {
        int grid[][] = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        int ans = obnumberOfEnclaves(grid);
        System.out.println(ans);
    }

    private static int obnumberOfEnclaves(int[][] grid) {
        int visit[][]=new int[grid.length][grid[0].length];
        //ignore count
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                    if(grid[i][j]==1){
                        q.add(new Node(i,j,-1));
                        visit[i][j]=1;
                    }
                }
            }
        }
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1};
        while(!q.isEmpty()){
            int row=q.peek().x;
            int col=q.peek().y;
            q.poll();

            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if( nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length &&
                        visit[nrow][ncol]!=1 && grid[nrow][ncol]==1){
                    q.add(new Node(nrow,ncol,-1));
                }
            }
        }

        int cnt = 0;
        for(int i = 0;i<grid.length;i++) {
            for(int j = 0;j<grid[0].length;j++) {
                // check for unvisited land cell
                if(grid[i][j] == 1 & visit[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}
