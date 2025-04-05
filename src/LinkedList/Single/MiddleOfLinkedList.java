package LinkedList.Single;

import java.util.*;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        // List of test cases
        List<Node> testCases = Arrays.asList(
                createList(new int[]{1, 2, 3, 4, 5}),  // Odd-length list
                createList(new int[]{1, 2, 3, 4, 5, 6}),  // Even-length list
                createList(new int[]{10}),  // Single-element list
                createList(new int[]{7, 9}),  // Two-element list
                null  // Null case
        );

        List<Integer> expectedResults = Arrays.asList(3, 4, 10, 9, null);

        for (int i = 0; i < testCases.size(); i++) {
            Node middle = findMiddle(testCases.get(i));
            Integer result = (middle != null) ? middle.data : null;
            String status = Objects.equals(result, expectedResults.get(i)) ? "✅" : "❌";
            System.out.println("Test " + (i + 1) + ": Middle = " + result + " (Expected: " + expectedResults.get(i) + ") " + status);
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

    private static Node findMiddle(Node head) {
        Node fast=head;
        Node slow=head;

        while (fast !=null && fast.next!=null && slow!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

}
