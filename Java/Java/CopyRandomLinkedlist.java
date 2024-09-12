package Java;

public class CopyRandomLinkedlist {

    public static void main(String[] args) {
        // Creating the linked list with random pointers
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Setting up random pointers
        head.random = head.next.next;          // 1 -> 3
        head.next.random = head;               // 2 -> 1
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next; // 4 -> 2
        head.next.next.next.next.random = head.next.next; // 5 -> 3

        System.out.println("Original list:");
        printList(head);

        // Creating a deep copy of the list
        Node copiedList = copyRandomList(head);

        System.out.println("\nCopied list:");
        printList(copiedList);
    }

    private static Node copyRandomList(Node head) {
        if(head == null)
            return null; 

        Node start = head;
        while(start != null){
            Node newNode = new Node(start.val);
            newNode.next = start.next;
            start.next = newNode;
            start = newNode.next;
        }

        start = head;
        while(start != null){
            if(start.random != null) {
            start.next.random = start.random.next;
            }
            start = start.next.next;
        }

        Node curr = head;
        Node copyHead = head.next;
        Node temp = copyHead;

        while (curr != null) {
            curr.next = curr.next.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            curr = curr.next;
            temp = temp.next;
        }


        return copyHead;

    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node: " + temp.val + ", Random: " + randomVal);
            temp = temp.next;
        }
    }
    
}
class Node {
        int val;
        Node next;
        Node random;

        Node(int val){
            this.val = val;
        }
}