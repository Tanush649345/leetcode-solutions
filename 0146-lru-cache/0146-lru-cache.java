class LRUCache {
    private class Node{
        Node prev = null;
        Node next = null;
        int val = 0;
        int key = 0;
    }
    private int capacity;
    private HashMap<Integer,Node> map = new HashMap<>();
    private Node head,tail;
    private void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insert(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        delete(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if(map.containsKey(key) ||map.size() == capacity ){
            if(map.containsKey(key)) node = map.get(key);
            else if(map.size() == capacity){
                node = tail.prev;
                map.remove(node.key);
            }
            delete(node);
        }
        if(!map.containsKey(key)) node = new Node();
        insert(node);
        node.val = value;
        node.key = key;
        map.put(key,node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */