package Graph.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SPinDAG {
    public static void main(String[] args)  {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int res[] = objshortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    private static int[] objshortestPath(int n, int m, int[][] edge) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            int wt=edge[i][2];
            adj.get(u).add(new Pair(v,wt));
        }

        int visited[]=new int[n];

        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                toposort(visited,i,adj,st);
            }
        }

        //distance
        int dist[]=new int[n];
        Arrays.fill(dist,(int)1e9);

        dist[0]=0;

        while(!st.isEmpty()){
            int node=st.pop();

            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i).first;
                int wt=adj.get(node).get(i).second;

                if(dist[node]+wt<dist[v]){
                    dist[v]=dist[node]+wt;
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            if(dist[i]==(int)1e9){
                dist[i]=-1;
            }
        }
        return dist;

    }

    private static void toposort(int[] visited, int i, ArrayList<ArrayList<Pair>> adj, Stack<Integer> st) {
        visited[i]=1;
        for(Pair x:adj.get(i)){
            int v=x.first;
            int wt=x.second;
            if(visited[v]!=1){
                toposort(visited,v,adj,st);
            }
        }
        st.push(i);
    }
}
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}