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
        HashMap<Node, Node> map = new HashMap<>();
        Node ret = new Node(head.val);
        Node itr1 = head.next;
        Node itr2 = ret;
        map.put(head, ret);
        while(itr1!=null){
            itr2.next = new Node(itr1.val);
            map.put(itr1, itr2.next);
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        itr1 = head;
        itr2 = ret;
        while(itr1!=null){
            itr2.random = map.get(itr1.random);
            itr1 = itr1.next;
            itr2 = itr2.next;
        }

        return ret;
    }
}
