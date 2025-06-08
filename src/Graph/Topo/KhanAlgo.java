package Graph.Topo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KhanAlgo {
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
        ArrayList<Integer> ar=new ArrayList<>();
        // calculate the indegree
        int indegree[]=new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> zeroIndgree=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                zeroIndgree.add(i);
            }
        }
        while (!zeroIndgree.isEmpty()){
            int temp=zeroIndgree.poll();
            ar.add(temp);
            for(Integer a:adj.get(temp)){
                indegree[a]--;
                if(indegree[a]==0)
                    zeroIndgree.add(a);
            }
        }

        return ar.stream().mapToInt(Integer::intValue).toArray();
    }
}
