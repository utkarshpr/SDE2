package BinaryTree.Hard;

import BinaryTree.Easy.Tree;

import java.util.*;

public class RootToPathNode {
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


        int targetLeafValue = 7;

        List<Integer> path = solveHard1(root, targetLeafValue);

        System.out.print("Path from root to leaf with value " +
                targetLeafValue + ": ");
        for (int i = 0; i < path.size(); ++i) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
    }

    public static List<Integer> solveHard1(Tree root, int targetLeafValue) {
        List<Integer> ans=new ArrayList<>();
        solveRootToPathNode(root,targetLeafValue,ans);
        return ans;
    }

    private static boolean solveRootToPathNode(Tree root, int targetLeafValue, List<Integer> ans) {
        if(root == null){
            return false;
        }

        ans.add(root.data);
        if(root.data==targetLeafValue){

            return true;
        }


       if( solveRootToPathNode(root.left,targetLeafValue,ans) ||solveRootToPathNode(root.right,targetLeafValue,ans))
           return true;
        ans.remove(ans.size()-1);

        return  false;
    }
}
