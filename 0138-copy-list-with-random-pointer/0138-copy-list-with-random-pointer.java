/*
// Definition for a Node.
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
*/
// Definition for a Node.

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create copy nodes and insert them next to original nodes
        insertCopyNodes(head);

        // Step 2: Connect random pointers for the copied nodes
        connectRandomPointers(head);

        // Step 3: Separate the copied list from the original list
        return separateLists(head);
    }

    private void insertCopyNodes(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = copyNode.next; // Move to the next original node
        }
    }

    private void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = temp.next; // The copied node
            if (temp.random != null) {
                copyNode.random = temp.random.next; // Set the random pointer
            }
            temp = copyNode.next; // Move to the next original node
        }
    }

    private Node separateLists(Node head) {
        Node original = head; // Pointer for the original list
        Node copyHead = head.next; // Head of the copied list
        Node copy = copyHead; // Pointer for the copied list

        while (original != null) {
            original.next = original.next.next; // Restore the original list
            if (copy.next != null) {
                copy.next = copy.next.next; // Move to the next copied node
            }
            original = original.next; // Move to the next original node
            copy = copy.next; // Move to the next copied node
        }

        return copyHead; // Return the head of the copied list
    }
}