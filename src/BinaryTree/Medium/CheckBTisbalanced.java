package BinaryTree.Medium;

import BinaryTree.Easy.Tree;

import static BinaryTree.Medium.heightofBST.maxDepth;

public class CheckBTisbalanced {
    public static void main(String[] args) {
        // Test 1: Balanced tree
        Tree balancedRoot = new Tree(1);
        balancedRoot.left = new Tree(2);
        balancedRoot.right = new Tree(3);
        System.out.println("Test 1 - Balanced tree: " + isBalanced(balancedRoot));

        // Test 2: Unbalanced tree
        Tree unbalancedRoot = new Tree(1);
        unbalancedRoot.left = new Tree(2);
        unbalancedRoot.left.left = new Tree(3);
        unbalancedRoot.left.left.left = new Tree(4);
        System.out.println("Test 2 - Unbalanced tree: " + isBalanced(unbalancedRoot));

        // Test 3: Empty tree
        Tree emptyRoot = null;
        System.out.println("Test 3 - Empty tree: " + isBalanced(emptyRoot));

        // Test 4: Single node
        Tree singleNode = new Tree(1);
        System.out.println("Test 4 - Single node tree: " + isBalanced(singleNode));

        // Test 5: Original complex unbalanced tree
        Tree complexRoot = new Tree(1);
        complexRoot.left = new Tree(2);
        complexRoot.right = new Tree(3);
        complexRoot.left.left = new Tree(4);
        complexRoot.left.right = new Tree(5);
        complexRoot.left.right.right = new Tree(6);
        complexRoot.left.right.right.right = new Tree(7);
        System.out.println("Test 5 - Complex unbalanced tree: " + isBalanced(complexRoot));
    }

    private static int isBalanced(Tree root) {
//        if(root == null)
//            return true;
//
//            int lh=maxDepth(root.left);
//            int rh=maxDepth(root.right);
//            if(Math.abs(lh-rh)<=1 && isBalanced(root.left)&&isBalanced(root.right))
//                return true;
//
//            return false;

        //optimatimal solution
        if(root == null)
            return 0;

        int lh=isBalanced(root.left);

        //single side tree
        if(lh==-1)
            return -1;

        int rh=isBalanced(root.right);

        if(rh==-1)
            return -1;

        if(Math.abs(lh-rh)>1)
            return  -1;

        return Math.max(lh,rh)+1;


    }
}
