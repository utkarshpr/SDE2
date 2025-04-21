package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        List<List<Integer>> result = levelOrder(root);
        System.out.println("Level Order Traversal of Tree:");
        for (List<Integer> level : result) {
            printList(level);
        }
    }

    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static List<List<Integer>> levelOrder(Tree root) {
        Queue<Tree> q=new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        q.add(root);
        while (!q.isEmpty()){
            int size=q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                Tree temp=q.poll();
                level.add(temp.data);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
