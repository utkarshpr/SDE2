package Graph.ShortestPath;

import java.lang.reflect.Array;
import java.util.*;

public class DijkstraPQ {
    public static void main(String[] args) {
        int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
        //add final values of adj here.
        int[] res= objdijkstra(V,adj,S);

        for(int i=0;i<V;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();


    }

    private static int[] objdijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {

        PriorityQueue<Pa> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        int []dist = new int[v];
        Arrays.fill(dist,(int)1e9);

        dist[s]=0;
        pq.add(new Pa(0,s));

        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int distance=pq.peek().distance;
            pq.poll();

            for(int i=0;i<adj.get(node).size();i++){
                int newNODE=adj.get(node).get(i).get(0);
                int dis=adj.get(node).get(i).get(1);

                if(dis+distance<dist[newNODE]){
                    dist[newNODE]=dis+distance;
                    pq.add(new Pa(dist[newNODE],newNODE));
                }
            }
        }
        return dist;

    }
}
class  Pa
{
    int distance;
    int node;
    Pa(int dis,int n){
        this.distance=dis;
        this.node=n;
    }
}
