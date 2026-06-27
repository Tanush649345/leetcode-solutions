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
    ListNode find_kth(ListNode head,int k){
        while(head!=null && k>1){
            head=head.next;
            k--;
        }
        return head;
    }
    ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1)return head;
        ListNode temp =head;
        ListNode ans = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode last = find_kth(temp,k);
            if(last == null) return ans;
            ListNode next = last.next;
            last.next = null;
            ListNode Newhead = reverse(temp);
            if(ans==head) ans = Newhead;
            else prev.next = Newhead;
            prev = temp;
            temp.next = next;
            temp = next;
        }
        return ans;
    }
}