package LinkedList.Single;

import java.util.*;

public class loopInLinkedList {
    public static void main(String[] args) {
        List<Node> testCases = new ArrayList<>();

        // Test Case 1: Loop Exists (1 -> 2 -> 3 -> 4 -> 5 -> back to 3)
        Node head1 = new Node(1);
        Node second1 = new Node(2);
        Node third1 = new Node(3);
        Node fourth1 = new Node(4);
        Node fifth1 = new Node(5);
        head1.next = second1;
        second1.next = third1;
        third1.next = fourth1;
        fourth1.next = fifth1;
        fifth1.next = third1; // Loop created
        testCases.add(head1);

        // Test Case 2: No Loop (1 -> 2 -> 3 -> 4 -> 5 -> null)
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        testCases.add(head2);

        // Test Case 3: Single Node with No Loop
        Node head3 = new Node(10);
        testCases.add(head3);

        // Test Case 4: Single Node with Loop (10 -> back to itself)
        Node head4 = new Node(10);
        head4.next = head4; // Self-loop
        testCases.add(head4);

        // Test Case 5: Empty List
        testCases.add(null);

        List<Boolean> expectedResults = Arrays.asList(true, false, false, true, false);

        for (int i = 0; i < testCases.size(); i++) {
            boolean result = detectCycle(testCases.get(i));
            boolean expected = expectedResults.get(i);
            String status = (result == expected) ? "✅" : "❌";
            System.out.println("Test " + (i + 1) + ": Cycle detected = " + result + " (Expected: " + expected + ") " + status);
        }

    }

    private static boolean detectCycle(Node head) {
        Node fast=head;
        Node slow=head;

        while(fast!=null && slow!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow)
                return  true;

        }
        return  false;
    }
}
