package BinaryTree.Hard;

import BinaryTree.Easy.Tree;

import java.util.*;

public class PrintKfromTarget {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        System.out.println(distanceK(root,root,2));
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode ,TreeNode> hm=new HashMap<>();
        List<Integer>  ans=new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null){
                    hm.put(temp.left,temp);
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    hm.put(temp.right,temp);
                    q.add(temp.right);
                }
            }
        }

        //traverse
        HashSet<TreeNode> visited=new HashSet<>();
        q.clear();
        q.add(target);
        visited.add(target);
        int level=0;
        while(!q.isEmpty()){

            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left != null && !visited.contains(temp.left)){
                    visited.add(temp);
                    q.add(temp.left);
                }
                if(temp.right != null && !visited.contains(temp.right)){
                    visited.add(temp);
                    q.add(temp.right);
                }
                TreeNode parent=hm.get(temp);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            level++;
        }
        System.out.println(level);// minimum time to burn the tree level --;
        while(!q.isEmpty()){
            ans.add(q.poll().data);
        }
        return  ans;

    }
}
class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    // Constructor to initialize
    // the node with a value
    public TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }

}

