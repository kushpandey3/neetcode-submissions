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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode l1Itr = l1;
        ListNode l2Itr = l2;
        ListNode l1Prev = null;
        while(l1Itr!=null && l2Itr!=null){
            l1Itr.val = l1Itr.val + l2Itr.val;
            if(l1Itr.val>=10){
                if(l1Itr.next!=null) l1Itr.next.val++;
                else l1Itr.next = new ListNode(1);
                l1Itr.val-=10;
            }
            l1Prev = l1Itr;
            l1Itr = l1Itr.next;
            l2Itr = l2Itr.next;
        }
        while(l1Itr!=null){
            if(l1Itr.val>=10){
                if(l1Itr.next!=null) l1Itr.next.val++;
                else l1Itr.next = new ListNode(1);
                l1Itr.val-=10;
            }
             l1Itr = l1Itr.next;
        }
        while(l2Itr!=null){
            l1Prev.next = l2Itr;
            l2Itr = l2Itr.next;
        }
        return l1;
    }
}
