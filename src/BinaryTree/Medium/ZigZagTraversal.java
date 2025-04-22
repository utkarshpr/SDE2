package BinaryTree.Medium;

import BinaryTree.Easy.Tree;

import java.util.*;

public class ZigZagTraversal {
    public static void main(String[] args) {
        // Test Case 1: Full Binary Tree
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6, 7)
        );

        runZigZagTest("Test Case 1: Full Binary Tree", root, expected);

        // Additional Test Case: One Node
        Tree root2 = new Tree(10);
        List<List<Integer>> expected2 = Arrays.asList(
                Arrays.asList(10)
        );
        runZigZagTest("Test Case 2: Single Node", root2, expected2);

        // Additional Test Case: Skewed Left
        Tree root3 = new Tree(1);
        root3.left = new Tree(2);
        root3.left.left = new Tree(3);
        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3)
        );
        runZigZagTest("Test Case 3: Skewed Left", root3, expected3);
    }

    public static void runZigZagTest(String testName, Tree root, List<List<Integer>> expected) {
        List<List<Integer>> actual = ZigZagLevelOrder(root);
        System.out.println(testName);
        System.out.println("Expected: " + expected);
        System.out.println("Actual  : " + actual);

        if (actual.equals(expected)) {
            System.out.println("✅ Test Passed!\n");
        } else {
            System.out.println("❌ Test Failed!\n");
        }
    }



    static void printResult(List<List<Integer>> result) {
            for (List<Integer> row : result) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
               // System.out.println();
            }
        }


    private static List<List<Integer>> ZigZagLevelOrder(Tree root) {
        List<List<Integer>> ans=new ArrayList<>() ;
        boolean swi=true;
        if (root == null)
        {
            return ans;
        }
        Queue<Tree>q =new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){

            int size=q.size();
            ArrayList<Integer> tempAns=new ArrayList<>();
            for(int i=0;i<size;i++){

                Tree temp=q.poll();
                tempAns.add(temp.data);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);

            }
            if(swi)
                ans.add(tempAns);
            else{
                Collections.reverse(tempAns);
                ans.add(tempAns);
            }
            swi=!swi;
        }
        return ans;

    }
}
