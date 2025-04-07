package LinkedList.Single;

public class RotateLinkedList {
    public static void main(String[] args) {
        testRotateRight();
    }

    private static void testRotateRight() {
        // Test Case 1: Standard case, k < length
        testCase(new int[]{1, 2, 3, 4, 5}, 2, new int[]{4, 5, 1, 2, 3});

        // Test Case 2: k = 0, no rotation
        testCase(new int[]{1, 2, 3, 4, 5}, 0, new int[]{1, 2, 3, 4, 5});

        // Test Case 3: k = length of list, no change
        testCase(new int[]{1, 2, 3, 4, 5}, 5, new int[]{1, 2, 3, 4, 5});

        // Test Case 4: k > length of list, should rotate (k mod length)
        testCase(new int[]{1, 2, 3, 4, 5}, 7, new int[]{4, 5, 1, 2, 3}); // 7 % 5 = 2, same as k=2

        // Test Case 5: Single element list
        testCase(new int[]{10}, 3, new int[]{10});

        // Test Case 6: Empty list
        testCase(new int[]{}, 2, new int[]{});
    }

    private static void testCase(int[] input, int k, int[] expected) {
        Node head = createLinkedList(input);
        Node result = rotateRighth(head, k);
        int[] actual = linkedListToArray(result);

        boolean isCorrect = java.util.Arrays.equals(actual, expected);
        System.out.println("Input: " + java.util.Arrays.toString(input) + ", k = " + k);
        System.out.println("Expected: " + java.util.Arrays.toString(expected));
        System.out.println("Actual  : " + java.util.Arrays.toString(actual));
        System.out.println(isCorrect ? "✅ Test Passed" : "❌ Test Failed");
        System.out.println("--------------------------------------");
    }

    private static Node rotateRighth(Node head, int k) {
        if (head == null || k == 0) return head;

        Node fast = head, slow = head;
        int length = 1;

        // Find length of list
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }

        // Adjust k if it's greater than the length
        k = k % length;
        if (k == 0) return head;

        fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        Node newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }

    private static Node createLinkedList(int[] values) {
        if (values.length == 0) return null;
        Node head = new Node(values[0]);
        Node temp = head;
        for (int i = 1; i < values.length; i++) {
            temp.next = new Node(values[i]);
            temp = temp.next;
        }
        return head;
    }

    private static int[] linkedListToArray(Node head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
