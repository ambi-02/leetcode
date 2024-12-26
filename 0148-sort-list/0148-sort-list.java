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
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        // Attach the remaining nodes
        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }

        return dummy.next; // Return the merged list starting from the next of dummy
    }

    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To keep track of the previous node

        while (fast != null && fast.next != null) {
            prev = slow; // Keep track of the previous node
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half from the right half
        if (prev != null) {
            prev.next = null; // Split the list into two halves
        }

        return slow; // Return the middle node
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Find the middle node
        ListNode mid = findMid(head);
        ListNode left = sortList(head); // Sort the left half
        ListNode right = sortList(mid); // Sort the right half

        // Merge the sorted halves
        return merge(left, right);
    }
}