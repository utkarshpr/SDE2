package BinaryTree.Medium;

import BinaryTree.Easy.Tree;

public class heightofBST {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.left.right.right = new Tree(6);
        root.left.right.right.right = new Tree(7);

        int depth = maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }

    public static int maxDepth(Tree root) {
        if (root== null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right);
    }
}
