package Graph.easy;

import java.util.*;

public class CyclicDetection {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList< >());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = objisCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean objisCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        int par[]=new int[n];
        Arrays.fill(par,-1);
        int vis[]=new int[n];
        Arrays.fill(vis,0);
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(checkCycle(adj,n,par,vis,i))return true;
            }
    }
        return false;
}

    private static boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int n, int[] par, int[] vis,int node) {
        vis[node]=1;
        Queue<ParentToChild> q=new LinkedList<>();
        q.offer(new ParentToChild(node,-1));
        while(!q.isEmpty()){
            int child = q.peek().first;
            int parents = q.peek().second;
            q.poll();
            for(Integer x:adj.get(node)){
                if(vis[x]==0){
                    q.add(new ParentToChild(x,node));
                    vis[x]=1;
                }
                else if(parents != x) return true;
            }
        }
        return  false;
    }

}
class ParentToChild{
    int first;
    int second;
    public ParentToChild(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
