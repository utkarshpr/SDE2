package BinaryTree.Medium;

import BinaryTree.Easy.Tree;

import java.util.ArrayList;
import java.util.List;


public class BoundaryTraversal{
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        List<Integer> result = printBoundary(root);

        System.out.print("Boundary Traversal: ");
        printResult(result);

    }
    static void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private static List<Integer> printBoundary(Tree root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if(!isLeaf(root)){
            res.add(root.data);
        }
        leftNode(res,root);
        leafNode(res,root);
        rightNode(res,root);
        return res;
    }

    private static void leafNode(List<Integer> res, Tree root) {
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left!=null){
            leafNode(res,root.left);
        }
        if(root.right!=null){
            leafNode(res,root.right);
        }
    }

    private static void leftNode(List<Integer> res, Tree root) {
        Tree curr=root.left;
        while (curr!=null){

            if(!isLeaf(curr))
            {
                res.add(curr.data);
            }
            if(curr.left !=null){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
    }

    private static void rightNode(List<Integer> res, Tree root) {
        Tree curr=root.right;
        while (curr!=null){

            if(!isLeaf(curr))
            {
                res.add(curr.data);
            }
            if(curr.right !=null){
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }
        }
    }

    private static boolean isLeaf(Tree root) {
        return root.left == null && root.right == null;
    }
}
