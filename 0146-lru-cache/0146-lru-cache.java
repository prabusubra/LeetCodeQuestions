class LRUCache {
    
    private LinkedHashMap<Integer, Integer> cache;
    
    LRUCache(int cap) {
        // code here
        this.cache = new LinkedHashMap(cap, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry entries) {
                return size() > cap;
            }
        };
        
    }

    public int get(int key) {

        return this.cache.getOrDefault(key, -1);
        //  code here
    }

        
    public void put(int key, int value) {
        //  code here
        this.cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */