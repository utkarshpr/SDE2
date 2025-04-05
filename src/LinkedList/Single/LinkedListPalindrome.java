package LinkedList.Single;


import java.util.*;

import static LinkedList.Single.ReverseLinkedList.printLinkedList;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        List<int[]> testCases = Arrays.asList(
                new int[]{1, 2, 3, 2, 1},  // Palindrome
                new int[]{1, 5, 2, 52, 1},  // Not a palindrome
                new int[]{1, 2, 2, 1},  // Palindrome
                new int[]{1},  // Single element (Palindrome)
                new int[]{},  // Empty list (Palindrome)
                new int[]{1, 2, 3}  // Not a palindrome
        );

        List<Boolean> expectedResults = Arrays.asList(true, false, true, true, true, false);

        for (int i = 0; i < testCases.size(); i++) {
            Node head = createList(testCases.get(i));
            boolean result = isPalindrome(head);
            boolean expected = expectedResults.get(i);
            String status = (result == expected) ? "✅" : "❌";
            System.out.println("Test " + (i + 1) + ": Is palindrome? " + result + " (Expected: " + expected + ") " + status);
        }
    }

    private static Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    private static boolean isPalindrome(Node head) {
        Node firstHalf=head;
        Node fast=head;
        Node slow=head;
        while (fast != null && slow !=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node mid=slow;
        Node prev=Reverse(slow);
        while(firstHalf!=mid && prev!=null){
            if(firstHalf.data != prev.data)
                return false;
            firstHalf=firstHalf.next;
            prev=prev.next;
        }
        return true;
    }

    private static Node Reverse(Node head) {
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
}
