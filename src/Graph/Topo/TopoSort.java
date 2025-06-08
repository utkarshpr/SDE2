package Graph.Topo;

import java.util.*;

public class TopoSort {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = SolutiontopoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    private static int[] SolutiontopoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st=new Stack<>();
        int vis[]=new int[v];

        for(int i=0;i<v;i++){
            if(vis[i]!=1){
                dfscall(vis,adj,i,st);
            }
        }

        int ans[] = new int[v];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }

    private static void dfscall(int[] vis, ArrayList<ArrayList<Integer>> adj, int i,Stack<Integer> st) {
        vis[i]=1;

        for(Integer x:adj.get(i)){
            if(vis[x]!=1){
                dfscall(vis,adj,x,st);
            }
        }
        st.push(i);
    }
}
