class LRUCache {
    class Node{
        Node prev;
        Node next;
        Integer key;
        Integer val;
        public Node(Integer key, Integer val, Node prev, Node next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    class DoublyLinkedList {
        //values at the end of this deque are newer
        Node head;
        Node tail;
        int size;
        public DoublyLinkedList(){
            head = null;
            tail = null;
            size = 0;
        }
        public void add(Node n){
            if(head==null){
                head = n;
                tail = n;
            }
            else{
                n.prev = tail;
                tail.next = n;
                tail = n;
            }
            size++;
        } 
        public void remove(Node n){
            if(head==n){
                head = head.next;
            }
            if(tail==n){
                tail = tail.prev;
            }
            if(n.prev!=null){
                n.prev.next = n.next;
            }
            if(n.next!=null){
                n.next.prev = n.prev;
            }
            size--;
            n.prev = null;
            n.next = null;
        }
        //returns the key of the first node
        public Integer removeFirst(){
            int k = head.key;
            if(head==tail) tail = null;
            head = head.next;
            size--;
            return k;
        }
    }
    HashMap<Integer, Node> map;
    DoublyLinkedList list;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap(); 
        list = new DoublyLinkedList();    
        this.capacity = capacity; 
    }
    
    public int get(int key) {
        Node ret = map.get(key);
        if(ret==null) return -1;
        list.remove(ret);
        list.add(ret);
        return ret.val;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n!=null){
            n.val = value;
            list.remove(n);
            list.add(n);
        }
        else{
            n = new Node(key, value, null, null);
            map.put(key, n);
            list.add(n);
        }
        if(list.size>capacity){
            map.remove(list.removeFirst());
        }
    }
}
