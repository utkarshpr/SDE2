package BinaryTree.Medium;

import BinaryTree.Easy.Tree;

import java.util.*;

public class TopBottomANDLeftRightView {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(4);
        root.left.right = new Tree(10);
        root.left.left.right = new Tree(5);
        root.left.left.right.right = new Tree(6);
        root.right = new Tree(3);
        root.right.right = new Tree(10);
        root.right.left = new Tree(9);

       List<List<Integer>> topView = topView(root);

        System.out.println(" Traversal: "+topView);

    }

    private static List<List<Integer>> topView(Tree root) {
        Map<Integer,ArrayList<int[]>> map=new TreeMap<>();
       List<List<Integer>> ans=new ArrayList<>();
        if(root == null){
            return  ans;
        }
        dfsvertical(root,0,0,map);
       // System.out.println(map);


        for (Map.Entry<Integer, ArrayList<int[]>> entry : map.entrySet()) {
            int hd = entry.getKey();
            ArrayList<int[]> list = entry.getValue();

            Collections.sort(list, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));


            List<Integer> ar=new ArrayList<>();
            for (int[] arr : list) {
               ar.add(arr[1]);
            }
           ans.add(ar);
        }


        /*
        Horizontal
         */
        Map<Integer, ArrayList<Integer>> map1 = new TreeMap<>(); // TreeMap to keep HD in sorted order
        dfshorizontal(root, 0, 0, map1);  // Start DFS from HD 0 and depth 0
        System.out.println(map1);

        return ans;
    }

    private static void dfsvertical(Tree root, int i, int i1, Map<Integer, ArrayList<int[]>> map) {
        if(root==null)
            return;
        map.putIfAbsent(i,new ArrayList<>());
        map.get(i).add(new int[]{i1,root.data});
        dfsvertical(root.left,i-1,i1+1,map);
        dfsvertical(root.right,i+1,i1+1,map);
    }
    private static void dfshorizontal(Tree root, int i, int i1, Map<Integer, ArrayList<Integer>> map) {
        if(root==null)
            return;
        map.putIfAbsent(i1,new ArrayList<>());
        map.get(i1).add(root.data);
        dfshorizontal(root.left,i-1,i1+1,map);
        dfshorizontal(root.right,i+1,i1+1,map);
    }


    public static void print(Map<Integer, ArrayList<int[]>> map){
        for (Map.Entry<Integer, ArrayList<int[]>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<int[]> list = entry.getValue();

            System.out.print("Key: " + key + " -> ");

            for (int[] arr : list) {
                System.out.print("[");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i]);
                    if (i < arr.length - 1) System.out.print(", ");
                }
                System.out.print("] ");
            }

            System.out.println(); // move to next line after each key
        }

    }
}
