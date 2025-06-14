package Graph.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MazeDistance {
    public static void main(String[] args) {
        int[] source={0,1};
        int[] destination={2,2};

        int[][] grid={{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};

        int res = obshortestPath(grid, source, destination);

        System.out.print(res);
        System.out.println();
    }

    private static int obshortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0]==destination[0] && source[1]==destination[1])
            return 0;
        int dis[][]=new int[grid.length][grid[0].length];
        for(int ar[]:dis){
            Arrays.fill(ar,(int)1e9);
        }
        Queue<Tuple> q=new LinkedList<>();
        dis[source[0]][source[1]]=0;
        q.add(new Tuple(source[0],source[1],0));
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int n_row=q.peek().row;
            int n_col=q.peek().col;
            int n_d=q.peek().dis;
            q.poll();
            for(int i=0;i<4;i++){
                int newr = n_row + dr[i];
                int newc = n_col + dc[i];

                if(newr >= 0 && newr < grid.length && newc >= 0 && newc < grid[0].length
                        && grid[newr][newc] == 1 && n_d + 1 < dis[newr][newc]){
                    dis[newr][newc]=n_d+1;

                    if(newr==destination[0] && newc== destination[1])return n_d+1;

                    q.add(new Tuple(newr,newc,n_d+1));
                }
            }
        }
        return -1;
    }
}
class Tuple{
    int row;
    int col;
    int dis;
    public Tuple(int x,int y, int d){
        this.row=x;
        this.col=y;
        this.dis=d;
    }
}
