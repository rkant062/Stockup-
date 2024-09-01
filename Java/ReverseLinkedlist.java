class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedlist {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while (curr != null) {
            // Save the next node
            next = curr.next;
            
            // Reverse the current node's pointer
            curr.next = prev;
            
            // Move the pointers one step forward
            prev = curr;
            curr = next;
        }
        
        // prev is the new head of the reversed list
        return prev;
    }

    public static void main(String[] args) {
        // Example usage
        ReverseLinkedlist solution = new ReverseLinkedlist();
        
        // Creating a simple linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println("Original List:");
        printList(head);
        
        // Reversing the linked list
        ListNode reversedHead = solution.reverseList(head);
        
        System.out.println("Reversed List:");
        printList(reversedHead);
    }
    
    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
