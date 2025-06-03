package Graph;
import java.util.*;
public class DFS {
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        ArrayList < Integer > ans = sldfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }

    private static ArrayList<Integer> sldfsOfGraph(int i, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ar=new ArrayList<>();
        int vis[]=new int[i];
        dfsZSl(adj,vis,ar,0);
        return  ar;
    }

    private static void dfsZSl(ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> ar, int i) {
       vis[i]=1;
       ar.add(i);

       for(Integer x:adj.get(i)){
           if(vis[x]==0){
               dfsZSl(adj,vis,ar,x);
           }
       }
    }
}
