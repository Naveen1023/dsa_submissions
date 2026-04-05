class MyCircularQueue {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    int maxSize;
    int currSize;
    Node first;
    Node last;
    public MyCircularQueue(int k) {
        maxSize = k ;
        currSize = 0;
        first = null;
        last = null;
    }
    
    public boolean enQueue(int value) {

        if(currSize == maxSize) return false;

        Node newNode = new Node(value);
        
        if(first == null) first = newNode;  // 1st node
        if(last == null) last = newNode;   // 1st node
        else {
            last.next = newNode;
            last = newNode;
        }
        last.next = first;        
        currSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(currSize == 0) return false;
        else if(currSize == 1) {
            first = null;
            last = null;
            currSize = 0;
            return true;
        }
        last.next = first.next;
        first = first.next;
        currSize--;

        return true;
    }
    
    public int Front() {
        if(first == null) return -1;

        return first.val;
    }
    
    public int Rear() {
        if(last == null) return -1;

        return last.val;
    }
    
    public boolean isEmpty() {
        if(currSize == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(currSize == maxSize) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */