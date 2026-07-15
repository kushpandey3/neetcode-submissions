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
       if(head==null) return null;
       Node itr = head;
       //Add in duplicates
       while(itr!=null){
            Node ins = new Node(itr.val);
            ins.next = itr.next;
            itr.next = ins;
            itr = ins.next;
       }
       itr = head;
       //Assign randoms
       while(itr!=null){
        if(itr.random!=null) itr.next.random = itr.random.next;
        itr = itr.next.next;
       }
       //Delete originals
       itr = head;
       Node ret = head.next;
       while(itr!=null){
        Node copy = itr.next;
        itr.next = copy.next;
        if(copy.next!=null){
            copy.next = copy.next.next;
        }
        itr = itr.next;
       }
       return ret;
    }
}
