package Graph.easy;

import java.util.*;

public class CyclicDetectionDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList< >());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = objisCycleDFS(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean objisCycleDFS(int i, ArrayList<ArrayList<Integer>> adj) {

        int vis[]=new int[i];
        Arrays.fill(vis,0);
        for(int x=0;x<i;x++){
            if(vis[x]==0){
                if(dfsCycle(vis,adj,x,-1))return  true;
            }
        }
        return  false;
    }

    private static boolean dfsCycle(int[] vis, ArrayList<ArrayList<Integer>> adj, int current,int parent) {

        vis[current]=1;

        for(Integer x:adj.get(current)){
            if(vis[x]==0){
                dfsCycle(vis,adj,x,current);
            }
            else if(x != parent)return true;
        }
        return  false;
    }
}
