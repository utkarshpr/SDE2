package Graph.easy;

public class XO {
    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        // n = 5, m = 4
        char[][] ans = obfill(5, 4, mat);
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] obfill(int n, int m, char[][] mat) {
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};
        int vis[][] = new int[n][m];
        for(int j = 0 ; j<m;j++) {
            if(vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delrow, delcol);
            }

            if(vis[n-1][j] == 0 && mat[n-1][j] == 'O') {
                dfs(n-1,j,vis,mat, delrow, delcol);
            }
        }

        for(int i = 0;i<n;i++) {
            if(vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delrow, delcol);
            }

            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat, delrow, delcol);
            }
        }

        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(vis[i][j]!=1 && mat[i][j]=='O')
                    mat[i][j]='X';
            }
        }
        return  mat;
    }

    private static void dfs(int i, int j, int[][] vis, char[][] mat, int[] delrow, int[] delcol) {
        vis[i][j]=1;
        for(int x=0;x<4;x++){
            int nrow=i+delrow[x];
            int ncol=j+delcol[x];
            if(nrow>=0 && ncol>=0 && nrow<mat.length && ncol <mat[0].length &&mat[i][j]=='O'&& vis[nrow][ncol]!=1){
                dfs(nrow,ncol,vis,mat,delrow,delcol);
            }
        }
    }
}
