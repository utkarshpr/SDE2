package Graph.easy;

import java.util.ArrayList;

public class NoofProvincess {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer> >();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);

        System.out.println(obnumProvinces(adj,3));
    }

    private static int obnumProvinces(ArrayList<ArrayList<Integer>> adj, int n) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n;i++) {
            adjLs.add(new ArrayList<Integer>());
        }

        // to change adjacency matrix to list
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                // self nodes are not considered
                if(adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int vis[]=new int[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                dfscall(adjLs,vis,i);
            }
            c++;
        }
        return  c;
    }

    private static void dfscall(ArrayList<ArrayList<Integer>> adj, int[] vis, int i) {
        vis[i]=1;

        for(Integer x:adj.get(i)){
            if(vis[x]==0){
                dfscall(adj,vis,x);
            }
        }
    }
}
