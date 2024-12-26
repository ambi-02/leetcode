/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class Solution {
    // Function to reverse the linked list
    private ListNode reverseLinkedList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev; // New head of the reversed list
    }

    // Function to get the Kth node from a given position in the linked list
    private ListNode getKthNode(ListNode temp, int k) {
        k -= 1; // Decrement K as we start from the 1st node
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp; // Return the Kth node
    }

    // Function to reverse nodes in groups of K
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        // Check if the list has enough nodes to reverse
        while (temp != null) {
            ListNode kThNode = getKthNode(temp, k);
            if (kThNode == null) {
                // If there are not enough nodes left, return the head
                if (prevLast != null) {
                    prevLast.next = temp; // Link the last node of the previous group
                }
                break;
            }

            ListNode nextNode = kThNode.next; // Store the next node after the Kth node
            kThNode.next = null; // Disconnect the Kth node to prepare for reversal

            // Reverse the nodes from temp to kThNode
            ListNode reversedHead = reverseLinkedList(temp);

            // Adjust the head if the reversal starts from the head
            if (head == temp) {
                head = kThNode; // New head of the list
            } else {
                prevLast.next = kThNode; // Link the last node of the previous group
            }

            // Update the pointer to the last node of the previous group
            prevLast = temp;

            // Move to the next group
            temp = nextNode;
        }

        return head; // Return the head of the modified linked list
    }
}