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

//APPROACH 1 
        // HashSet<ListNode> st = new HashSet<>();
        
        // // Traverse the first list and add all nodes to the HashSet
        // while (headA != null) {
        //     st.add(headA);
        //     headA = headA.next;
        // }
        
        // // Traverse the second list and check for intersection
        // while (headB != null) {
        //     if (st.contains(headB)) {
        //         return headB; // Intersection found
        //     }
        //     headB = headB.next;
        // }
        
        // return null; // No intersection

// APPROACH 2
    //     int diff= getDiff(headA,headB);
    //     if(diff<0){
    //         while(diff++!=0) headB=headB.next;
    //     }else{
    //         while(diff--!=0) headA=headA.next;
    //     }
    //     while(headA!=null){
    //         if(headA==headB) return headA;

    //         headA=headA.next;
    //         headB=headB.next;
    //     }
    //     return headA;
    // }
    // public static int getDiff(ListNode headA, ListNode headB){
    //     int n1=0;
    //     int n2=0;
    //     while(headA!=null || headB!=null){
    //         if(headA!=null){
    //             n1++;
    //             headA=headA.next;
    //         }
    //          if(headB!=null){
    //             n2++;
    //             headB=headB.next;
    //         }
    //     }
    //     return n1-n2;
    // }

//  APPROACH 3
        ListNode t1=headA;
        ListNode t2=headB;

        while(t1!=t2){
            t1 = t1 == null? headB:t1.next;
        t2 = t2 == null? headA:t2.next;
        }
return t1;
    }
}