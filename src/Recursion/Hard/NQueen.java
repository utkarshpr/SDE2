package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        int N = 4;
        List <List< String >> queen = solveNQueens(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> res=new ArrayList<>();
        dfs(res,board,0,0);
        return res;
    }

    private static void dfs(List<List<String>> res, char[][] board, int row, int col) {
        if(row==board.length){
            res.add(construct(board));
            return;
        }
        for(int j=col;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                dfs(res,board,row+1,0);
                board[row][j]='.';
            }
        }


    }
    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for(int i=0;i<board.length;i++){
            if (board[row][i]=='Q'){
                return false;
            }
        }
        for(int j=0;j<board.length;j++){
            if(board[j][col]=='Q')
                return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
    return true;
    }
}
