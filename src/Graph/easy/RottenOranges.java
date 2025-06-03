package Graph.easy;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }

    private static int orangesRotting(int[][] arr) {
        if(arr==null ||arr.length==0){
            return 0;
        }
        Queue<int[]> rotten=new LinkedList<>();
        int count_Fresh=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==2){
                    rotten.offer(new int[]{i , j});
                }
                else if(arr[i][j]==1){
                    count_Fresh++;
                }
            }
        }
        if(count_Fresh==0){
            return  0;
        }
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        int co=0;
        while(!rotten.isEmpty()){
            int size=rotten.size();
            boolean newRotten = false;
            for(int i=0;i<size;i++){
                int[] point = rotten.poll();
                for(int j=0;j<4;j++){
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    if(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || arr[x][y] == 0 ||
                            arr[x][y] == 2) continue;
                    arr[x][y]=2; //visited mark;
                    count_Fresh--;
                    newRotten=true;
                    rotten.offer(new int[]{x,y});
                }
            }
            if(newRotten){
                co++;
            }
        }
        return  count_Fresh==0?co:-1;
    }
}
