package Graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList < Integer > ans = slbfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }

    private static ArrayList<Integer> slbfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ar=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int vis[]=new int[n];
        q.add(0);
        vis[0]=1;
        while(!q.isEmpty()){
            Integer temp=q.poll();
            ar.add(temp);

            for(Integer x:adj.get(temp)){
                if(vis[x]==0){
                    vis[x]=1;
                    q.add(x);
                }
            }
        }
       return (ar);
    }
}
