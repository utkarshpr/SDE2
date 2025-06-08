package BinaryTree.Hard;

import java.util.HashMap;
import java.util.Vector;

public class InorderANDPreorder {
        public static void main(String[] args) {
            Vector<Integer> inorder = new Vector<>(java.util.Arrays.asList(9, 3, 15, 20, 7));
            Vector<Integer> preorder = new Vector<>(java.util.Arrays.asList(3, 9, 20, 15, 7));

            TreeNode root = solbuildTree(preorder, inorder);

            System.out.println("Inorder of Unique Binary Tree Created:");
            printInorder(root);
            System.out.println();

    }

    private static TreeNode solbuildTree(Vector<Integer> preorder, Vector<Integer> inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int c=0;
        for(Integer i:inorder){
            hm.put(i,c++);
        }
       return helper(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1,hm);

    }

    private static TreeNode helper(Vector<Integer> preorder, int ps, int pe,
                                   Vector<Integer> inorder, int is, int ie, HashMap<Integer, Integer> hm) {
        if(ps>pe || is>ie)
            return  null;
        TreeNode root=new TreeNode(preorder.get(ps));

        int position=hm.get(root.data);

        int leftsize=position-is;

        root.left=helper(preorder,ps+1,ps+leftsize,inorder,is,position-1,hm);
        root.right=helper(preorder,ps+leftsize+1,pe,inorder,position+1,ie,hm);

    return  root;
    }

    private static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }
}
