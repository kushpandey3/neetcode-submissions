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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head, curr = null, prev = null;
        int it = 0;
        while(ahead!=null){
            ahead = ahead.next;
            it++;
            if(it==n) curr = head;
            if(it==n+1) prev = head;
            if(it>n+1){
                prev = prev.next;
                curr = curr.next;
            }
            else if(it>n){
                curr = curr.next;
            }
        }
        if(prev!=null) prev.next = curr.next;
        else if(curr==null) return null;
        else return curr.next;
        return head;
    }
}
