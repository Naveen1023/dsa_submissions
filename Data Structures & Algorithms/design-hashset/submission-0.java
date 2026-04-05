class MyHashSet {
    int set[];
    int size = 1000001;
    public MyHashSet() {
        set = new int[size];
        Arrays.fill(set, -1);
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = -1;
    }
    
    public boolean contains(int key) {
        if(set[key] == key) return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */