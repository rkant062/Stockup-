package Java;



public class ReverseRandomLinkedList{

    // Function to reverse the linked list and adjust random pointers
    public static Node reverseListWithRandom(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Reverse the `next` pointers of the linked list
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Now, `prev` points to the new head of the reversed list.
        Node newHead = prev;

        // Step 2: Adjust the `random` pointers in the reversed list
        Node original = head;  // Keep track of the original nodes
        Node reversed = newHead;  // Keep track of the reversed nodes

        // Create a map to link original nodes to reversed nodes
        java.util.HashMap<Node, Node> map = new java.util.HashMap<>();

        // Build the mapping from original nodes to reversed nodes
        while (original != null) {
            map.put(original, reversed);
            original = original.next;
            reversed = reversed.next;
        }

        // Now adjust the `random` pointers for reversed nodes
        reversed = newHead;
        original = head;

        while (reversed != null) {
            if (original.random != null) {
                reversed.random = map.get(original.random);
            } else {
                reversed.random = null; // Explicitly setting to null if random is null
            }
            reversed = reversed.next;
            original = original.next;
        }

        return newHead;
    }

    // Helper function to print the list (including random pointers)
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node: " + curr.val + ", Random: " + randomVal);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // Create the linked list with random pointers
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Set up random pointers
        head.random = head.next.next;         // 1.random -> 3
        head.next.random = head;              // 2.random -> 1
        head.next.next.random = head.next.next.next.next; // 3.random -> 5
        head.next.next.next.random = head.next; // 4.random -> 2
        head.next.next.next.next.random = head.next.next; // 5.random -> 3

        System.out.println("Original list:");
        printList(head);

        // Reverse the list and adjust random pointers
        Node reversedList = reverseListWithRandom(head);

        System.out.println("\nReversed list:");
        printList(reversedList);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}