package LinkedList.Single;

import java.util.*;

public class ReverseLinkedList {
    public static void main(String[] args) {
        // List of test cases
        List<int[]> testCases = Arrays.asList(
                new int[]{1, 3, 2, 4},  // Normal case
                new int[]{5, 10, 15},  // Another normal case
                new int[]{7},  // Single element
                new int[]{},  // Empty list
                new int[]{9, 8}  // Two elements
        );

        List<int[]> expectedResults = Arrays.asList(
                new int[]{4, 2, 3, 1},
                new int[]{15, 10, 5},
                new int[]{7},
                new int[]{},
                new int[]{8, 9}
        );

        for (int i = 0; i < testCases.size(); i++) {
            Node head = createList(testCases.get(i));
            head = reverseLinkedList(head);
            List<Integer> result = linkedListToList(head);
            List<Integer> expected = Arrays.stream(expectedResults.get(i)).boxed().toList();

            String status = result.equals(expected) ? "✅" : "❌";
            System.out.println("Test " + (i + 1) + ": Reversed = " + result + " (Expected: " + expected + ") " + status);
        }
    }
    private static List<Integer> linkedListToList(Node head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.data);
            head = head.next;
        }
        return result;
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

    private static void printLinkedList(Node head) {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;

        }
        System.out.println();
    }
}
