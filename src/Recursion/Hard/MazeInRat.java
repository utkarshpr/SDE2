package Recursion.Hard;

import java.util.ArrayList;

public class MazeInRat {
    public static void main(String[] args) {
        int n = 4;
        int[][] a = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};

        ArrayList< String > res = objindPath(a, n);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static ArrayList<String> objindPath(int[][] a, int n) {
        boolean visited[][]=new boolean[a.length][a[0].length];
        ArrayList < String > ans = new ArrayList < > ();
        if (a[0][0]==0) return ans;
        solve(a,0,0,"",visited,ans);
        return ans;
    }

    private static void solve(int[][] a,  int i, int j, String s, boolean[][] vis,ArrayList<String> ans) {
        if(i==a.length-1 && j==a[0].length-1){
            ans.add(s);
            return ;
        }
        vis[i][j]=true;
        if(i+1<a.length && !vis[i+1][j]  && a[i+1][j]==1){
            solve(a,i+1,j,s+"D",vis,ans);
        }

        // left
        if (j - 1 >= 0 && !vis[i][j - 1] && a[i][j - 1] == 1) {
            solve(a,i,j-1,s+"L",vis,ans);
        }

        // right
        if (j + 1 < a[0].length && !vis[i][j + 1] && a[i][j + 1] == 1) {
            solve(a,i,j+1,s+"R",vis,ans);
        }

        // upward
        if (i - 1 >= 0 && !vis[i - 1][j] && a[i - 1][j] == 1) {
            solve(a,i-1,j,s+"U",vis,ans);
        }
        vis[i][j]=false;
    }


}
