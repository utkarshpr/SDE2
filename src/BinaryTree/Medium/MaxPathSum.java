package BinaryTree.Medium;

import BinaryTree.Easy.Tree;

public class MaxPathSum {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.left.right.right = new Tree(6);
        root.left.right.right.right = new Tree(7);

        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }

    private static int maxPathSum(Tree root) {
        int sum[]=new int[1];
        sumOfTree(root,sum);
        return sum[0];
    }

    private static int sumOfTree(Tree root, int[] sum) {
        if (root == null){
            return 0;
        }
        int lh=Math.max(0,sumOfTree(root.left,sum));
        int rh=Math.max(0,sumOfTree(root.right,sum));
        sum[0]=Math.max(sum[0],lh+rh+root.data);

        return root.data+Math.max(lh,rh);

    }
}
