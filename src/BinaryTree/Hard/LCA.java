package BinaryTree.Hard;

import BinaryTree.Easy.Tree;

import java.util.List;

import static BinaryTree.Hard.RootToPathNode.solveHard1;

public class LCA {
    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(5);
        root.right = new Tree(1);
        root.left.left = new Tree(6);
        root.left.right = new Tree(2);
        root.right.left = new Tree(0);
        root.right.right = new Tree(8);
        root.left.right.left = new Tree(7);
        root.left.right.right = new Tree(4);

        int node1 = 7;
        int node2 = 4;

        int lca = findLCA(root, node1, node2);
        if (lca!=-1)
            System.out.println("Lowest Common Ancestor of " + node1 + " and " + node2 + " is: " + lca);
        else
            System.out.println("Lowest Common Ancestor donot exist ");
        }


    private static int findLCA(Tree root, int node1, int node2) {
        List<Integer> a=solveHard1(root,node1);
        List<Integer> b=solveHard1(root,node2);
        System.out.println(a);
        System.out.println(b);
        int size=Math.min(a.size(),b.size());
        int common=-1;
        for(int i=0;i<size;i++) {
            if(a.get(i)==b.get(i)){
                common=a.get(i);
            }
        }
        return common;
    }

}
