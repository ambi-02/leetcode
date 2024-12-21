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

class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Check for empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head; // Pointer for odd indexed nodes
        ListNode even = head.next; // Pointer for even indexed nodes
        ListNode evenHead = even; // Store the head of the even indexed nodes

        // Traverse the list and rearrange the nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Link the current odd node to the next odd node
            odd = odd.next; // Move the odd pointer to the next odd node
            even.next = even.next.next; // Link the current even node to the next even node
            even = even.next; // Move the even pointer to the next even node
        }

        // Connect the end of the odd indexed list to the head of the even indexed list
        odd.next = evenHead;

        return head; // Return the head of the modified list
    }
}