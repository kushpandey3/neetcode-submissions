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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow = head, fast = head, end = null;
        //Find middle node and node just before it
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse second half with the head at prev
        ListNode prev = null, curr = slow, next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //Merge in correct order
        ListNode itr = head;
        while(itr!=null&&prev!=null){
            ListNode temp1 = itr.next;
            ListNode temp2 = prev.next;
            itr.next = prev;
            prev.next = temp1;
            itr = temp1;
            prev = temp2;
        }
    }
}
