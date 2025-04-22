package BinaryTree.Medium;

import BinaryTree.Easy.Tree;

public class daimeterofTree {
    public static void main(String[] args) {
        runTestCase("Test Case 1: Skewed Left Tree", createSkewedLeftTree(), 3);
        runTestCase("Test Case 2: Balanced Tree", createBalancedTree(), 4);
        runTestCase("Test Case 3: Complex Tree", createComplexTree(), 5);
        runTestCase("Test Case 4: Single Node", new Tree(1), 0);
        runTestCase("Test Case 5: Two Nodes", createTwoNodeTree(), 1);
    }

    public static void runTestCase(String testName, Tree root, int expected) {
        int actual = diameterOfBinaryTree(root);
        System.out.println(testName);
        System.out.println("Expected Diameter: " + expected);
        System.out.println("Actual Diameter: " + actual);
        if (actual == expected) {
            System.out.println("✅ Test Passed!\n");
        } else {
            System.out.println("❌ Test Failed!\n");
        }
    }

    // Helper method: Skewed Left Tree (e.g., 1 -> 2 -> 3 -> 4)
    public static Tree createSkewedLeftTree() {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(3);
        root.left.left.left = new Tree(4);
        return root;
    }

    // Helper method: Balanced Tree
    public static Tree createBalancedTree() {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);
        return root;
    }

    // Helper method: Complex Tree (same as your original example)
    public static Tree createComplexTree() {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.left.right.right = new Tree(6);
        root.left.right.right.right = new Tree(7);
        return root;
    }

    // Helper method: Two Nodes
    public static Tree createTwoNodeTree() {
        Tree root = new Tree(1);
        root.right = new Tree(2);
        return root;
    }


    private static int diameterOfBinaryTree(Tree root) {
        int daim[]=new int[1];
        heightofDai(root,daim);
        return daim[0];
    }

    private static int heightofDai(Tree root, int[] daim) {
        if(root==null)
            return 0;
        int lh=heightofDai(root.left,daim);
        int rh=heightofDai(root.right,daim);
        daim[0]=Math.max(daim[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
}
