package LinkedList.Single;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Node1 {
    int data;
    Node1 next;
    Node1 child;

    Node1() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    Node1(int x) {
        this.data = x;
        this.next = null;
        this.child = null;
    }

    Node1(int x, Node1 nextNode, Node1 childNode) {
        this.data = x;
        this.next = nextNode;
        this.child = childNode;
    }
}

public class FlattenLinkedList {

    public static Node1 flattenLinkedList(Node1 head) {

        ArrayList<Integer> ar=new ArrayList<>();
        Node1 temp=head;
        while(temp !=null ){
            ar.add(temp.data);
            Node1 Child=temp;
            while(Child.child !=null){
                Child=Child.child;
                ar.add(Child.data);

            }
            temp=temp.next;
        }
        System.out.println();
       Collections.sort(ar);

        return convertArrToLinkedList(ar);

    }
    static Node1 convertArrToLinkedList(ArrayList<Integer> arr) {
        Node1 dummyNode = new Node1(-1);
        Node1 temp = dummyNode;

        for (int i = 0; i < arr.size(); i++) {
            temp.child = new Node1(arr.get(i));
            temp = temp.child;
        }
        return dummyNode.child;
    }
    public static void printLinkedList(Node1 head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }

    public static void printOriginalLinkedList(Node1 head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node1 head = new Node1(5);
        head.child = new Node1(14);

        head.next = new Node1(10);
        head.next.child = new Node1(4);

        head.next.next = new Node1(12);
        head.next.next.child = new Node1(20);
        head.next.next.child.child = new Node1(13);

        head.next.next.next = new Node1(7);
        head.next.next.next.child = new Node1(17);

        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        Node1 flattened = flattenLinkedList(head);
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}





