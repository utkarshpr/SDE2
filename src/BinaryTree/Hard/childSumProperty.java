package BinaryTree.Hard;

import BinaryTree.Easy.Tree;

public class childSumProperty {
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
        System.out.print("Binary Tree before modification: ");
       inorderTraversal(root);
        System.out.println();
        changeTree(root);
        System.out.print("Binary Tree after Children Sum Property: ");
        inorderTraversal(root);
        System.out.println();
    }

    private static void changeTree(Tree root) {
        
    }

    public static void inorderTraversal(Tree root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
}
