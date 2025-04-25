package BinaryTree.Hard;

import BinaryTree.Easy.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthofaBinaryTree {
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

        int maxWidth = widthOfBinaryTree(root);

        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }

    private static int widthOfBinaryTree(Tree root) {
        int ans =0;
        if(root == null)
            return 0;
        Queue<Pair<Tree, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().i;
            int first = 0,last = 0;
            for(int x=0;x<size;x++){
                int curri=q.peek().i-min;
                Tree node=q.peek().t;
                q.poll();
                if(x==0)
                    first=curri;
                if(x==size-1)
                    last=curri;

                if(node.left!=null){
                    q.add(new Pair<>(node.left,curri*2+1));
                }
                if(node.right!=null){
                    q.add(new Pair<>(node.right,curri*2+2));
                }
            }
            ans= Math.max(ans,last-first+1);
        }
        return  ans;
    }
}
class Pair<T, I extends Number> {
    Tree t;
    Integer i;

    public Pair(Tree t, Integer i) {
        this.t = t;
        this.i = i;
    }
}
