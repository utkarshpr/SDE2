package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        List<Integer> result = preOrder(root);

        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        List<Integer> result1 = inOrOrder(root);

        System.out.print("Inorder Traversal: ");
        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println();

        List<Integer> result2 = postOrder(root);

        System.out.print("Postorder Traversal: ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private static List<Integer> postOrder(Tree root) {
        List<Integer> preOr=new ArrayList<>();
        pnOrder1(preOr,root);
        return preOr;
    }

    private static void pnOrder1(List<Integer> preOr, Tree root) {
        if(root== null)
            return ;
        pnOrder1(preOr,root.left);
        pnOrder1(preOr,root.right);

        preOr.add(root.data);

    }

    private static List<Integer> inOrOrder(Tree root) {
        List<Integer> preOr=new ArrayList<>();
        inOrder1(preOr,root);
        return preOr;
    }

    private static void inOrder1(List<Integer> preOr, Tree root) {
        if(root== null)
            return ;

        inOrder1(preOr,root.left);
        preOr.add(root.data);
        inOrder1(preOr,root.right);
    }

    private static List<Integer> preOrder(Tree root) {
        List<Integer> preOr=new ArrayList<>();
         preOrder1(preOr,root);
         return preOr;
    }

    private static void preOrder1(List<Integer> preOr, Tree root) {
        if(root== null)
            return ;
        preOr.add(root.data);
        preOrder1(preOr,root.left);
        preOrder1(preOr,root.right);
    }
}
