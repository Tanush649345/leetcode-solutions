/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;
        while(n1 !=null && n1 !=null){
            if(n1 == n2) return n1;
            n1 = n1.next;
            n2 = n2.next;
            if(n1 == null && n2 == null) return null; 
            if(n1 == null) n1 = headB;
            if(n2 == null) n2 = headA;
        }
        return null;
    }
}