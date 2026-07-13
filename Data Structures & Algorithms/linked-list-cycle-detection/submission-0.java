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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        if(slow==null) return false;
        ListNode fast = head.next;
        while(fast!=null){
            if(slow==fast) return true;
            slow = slow.next;
            if(fast!=null) fast = fast.next;
            if(fast!=null) fast = fast.next;
        }
        return false;
    }
}
