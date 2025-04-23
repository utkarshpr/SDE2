package BinaryTree.Medium;

import BinaryTree.Easy.Tree;
import org.w3c.dom.Node;

import java.util.*;

import static BinaryTree.Medium.TopView.print;
import static BinaryTree.Medium.ZigZagTraversal.printResult;



public class verticalOrder {
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

        List<List<Integer>> verticalTraversal = findVertical(root);

        // Print the result
        System.out.print("Vertical Traversal: ");
        printResult(verticalTraversal);
    }
    static Map<Integer, ArrayList<int[]>> map = new TreeMap<>();
    private static List<List<Integer>>  findVertical(Tree root) {
       dfstree(root,0,0);
        List<List<Integer>> result = new ArrayList<>();
       print(map);
        for(ArrayList<int[]> list:map.values()){
            Collections.sort(list,(a,b)->a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
            ArrayList<Integer> current = new ArrayList<>();
            for(int[] num :  list) {
                current.add(num[1]);
            }
            result.add(current);
        }
        return result;
    }

    private static void dfstree(Tree root, int index, int dept) {
        if(root == null){
            return;
        }
        map.putIfAbsent(index,new ArrayList<>());
        map.get(index).add(new int[]{dept,root.data});
        dfstree(root.left,index-1,dept+1);
        dfstree(root.right,index+1,dept+1);
    }
}
