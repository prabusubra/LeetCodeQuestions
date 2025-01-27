class LRUCache {

    private LinkedHashMap<Integer, Integer> caches;

    public LRUCache(int capacity) {
        caches = new LinkedHashMap<>(capacity, 0.75F, true) {
            protected boolean removeEldestEntry(Map.Entry entries) { 
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return this.caches.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        this.caches.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */