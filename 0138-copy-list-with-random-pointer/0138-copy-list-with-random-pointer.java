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

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node dummy = head;
        while(head!=null){
            Node temp = new Node(head.val);
            temp.next = head.next;
            head.next = temp;
            head = head.next.next;
        }
        head = dummy;
        while(head!=null){
            if(head.random!=null)head.next.random = head.random.next;
            else head.next.random = null;
            head = head.next.next;
        }
        head = dummy;
        Node ans = dummy.next;
        while(head!=null){
            Node temp = head.next;
            head.next = head.next.next;
            if(temp.next!=null)temp.next = temp.next.next;
            else temp.next = null;
            head = head.next;
        }
        return ans;
    }
}