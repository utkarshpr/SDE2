package BinaryTree.Medium;

import BinaryTree.Easy.Tree;

public class identicatTree {
    public static void main(String[] args) {
        // Test Case 1: Identical Trees
        Tree root1a = new Tree(1);
        root1a.left = new Tree(2);
        root1a.right = new Tree(3);
        root1a.left.left = new Tree(4);

        Tree root1b = new Tree(1);
        root1b.left = new Tree(2);
        root1b.right = new Tree(3);
        root1b.left.left = new Tree(4);

        runIsIdenticalTest("Test Case 1: Identical Trees", root1a, root1b, true);

        // Test Case 2: Structure Mismatch
        Tree root2a = new Tree(1);
        root2a.left = new Tree(2);

        Tree root2b = new Tree(1);
        root2b.right = new Tree(2);

        runIsIdenticalTest("Test Case 2: Structure Mismatch", root2a, root2b, false);

        // Test Case 3: One Tree is Null
        Tree root3a = null;
        Tree root3b = new Tree(1);

        runIsIdenticalTest("Test Case 3: One Tree is Null", root3a, root3b, false);

        // Test Case 4: Both Trees Null
        runIsIdenticalTest("Test Case 4: Both Trees Null", null, null, true);

        // Test Case 5: Same Structure, Different Values
        Tree root5a = new Tree(1);
        root5a.left = new Tree(2);

        Tree root5b = new Tree(1);
        root5b.left = new Tree(99);

        runIsIdenticalTest("Test Case 5: Same Structure, Different Values", root5a, root5b, false);
    }

    public static void runIsIdenticalTest(String testName, Tree a, Tree b, boolean expected) {
        boolean actual = isIdentical(a, b);
        System.out.println(testName);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (actual == expected) {
            System.out.println("✅ Test Passed!\n");
        } else {
            System.out.println("❌ Test Failed!\n");
        }
    }


    private static boolean isIdentical(Tree root1, Tree root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.data == root2.data) && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
    }
}
