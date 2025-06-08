package Graph.easy;

import java.util.*;

public class BiparateGraph {
    public static void main(String[] args)
    {
        // V = 4, E = 4
        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = objsBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }

    private static boolean objsBipartite(int i, ArrayList<ArrayList<Integer>> adj) {
        int color[]=new int[i];
        Arrays.fill(color,-1);
        for(int j=0;j<i;j++){
            if(color[j]==-1){
               if( bfsh(color,j,0,adj)==false) return false;
            }
        }
        return  true;
    }

    private static boolean bfsh(int[] color, int i, int col, ArrayList<ArrayList<Integer>> adj) {
        color[i]=col;
        for(Integer x:adj.get(i)){
            if(color[x]==-1){
                bfsh(color,x,1-col,adj);
            }
            else if(color[x]==col )return  false;
        }
        return  true;
    }
}
