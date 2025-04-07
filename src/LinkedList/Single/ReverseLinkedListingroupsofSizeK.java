package LinkedList.Single;

import static LinkedList.Single.ReverseLinkedList.printLinkedList;

public class ReverseLinkedListingroupsofSizeK {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        head = kReverse(head, 4);

        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }

    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node temp=head;
        while (temp!=null){

            Node front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }


    private static Node kReverse(Node head, int i) {
       Node temp=head;
       Node prev =null;
       head=null;
       while(temp !=null) {
           Node nth = getNthNode(temp, i);
           if (nth == null) {
                if(prev!=null){
                    prev.next=temp;
                }
                break;
           }
           Node nextNode=nth.next;

           nth.next=null;

           Node rev=reverseLinkedList(temp);
           if(head==null){
               head=rev;
           }
           if(prev!=null)
                prev.next=rev;
          prev=temp;
          temp=nextNode;
       }
        return head;
    }

//    private static Node kReverse(Node head, int i) {
//        Node temp = head;
//        Node prev = null;
//        head = null; // Reset head initially
//
//        while (temp != null) {
//            Node nth = getNthNode(temp, i);
//            if (nth == null) {
//                if (prev != null) {
//                    prev.next = temp;
//                }
//                break;
//            }
//
//            Node nextNode = nth.next;
//            nth.next = null; // Disconnect k-group
//
//            Node rev = reverseLinkedList(temp);
//
//            if (head == null) {
//                head = rev; // First reversal updates head
//            }
//
//            if (prev != null) {
//                prev.next = rev; // Connect previous reversed part
//            }
//
//            prev = temp; // `temp` is now the last node of the reversed segment
//            temp = nextNode; // Move to the next segment
//        }
//        return head;
//    }

    private static Node getNthNode(Node temp, int i) {
        while(temp!=null && i!=1){
            temp=temp.next;
            i--;
        }
        return temp;
    }
}
