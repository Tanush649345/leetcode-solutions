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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null)return head;
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        if(k%n==0)return head;
        temp = head;
        ListNode Next = head;
        ListNode slow = head;
        for(int i = 0;i < (k%n);i++){
            Next = Next.next;
        }
        while(Next.next!=null){
            slow = slow.next;
            Next = Next.next;
        }
        Next.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}