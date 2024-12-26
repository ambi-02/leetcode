import java.util.HashSet;

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> st = new HashSet<>();
        
        // Traverse the first list and add all nodes to the HashSet
        while (headA != null) {
            st.add(headA);
            headA = headA.next;
        }
        
        // Traverse the second list and check for intersection
        while (headB != null) {
            if (st.contains(headB)) {
                return headB; // Intersection found
            }
            headB = headB.next;
        }
        
        return null; // No intersection
    }
}