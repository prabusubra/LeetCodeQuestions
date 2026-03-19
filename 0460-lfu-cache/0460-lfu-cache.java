class LFUCache {

    private int capacity;
    private Map<Integer, Set<Integer>> freqMap;
    private Map<Integer, Node> lfuCache;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.freqMap = new HashMap<>();
        this.lfuCache = new HashMap<>();


    }
    
    public int get(int key) {

        if (!lfuCache.containsKey(key)) {
            return -1;
        }

        updateFrequency(key);
        return lfuCache.get(key).val;

    }
    
    public void put(int key, int value) {
        
        if (capacity == 0) return;

        if (lfuCache.containsKey(key)) {
            Node node = lfuCache.get(key);
            node.val = value;

            updateFrequency(key);
            return;
        }

        //Remove 
        if (lfuCache.size() == capacity) {
            Set<Integer> keys = freqMap.get(minFreq);
            int evict = keys.stream().findFirst().get();

            keys.remove(evict);
            
            //Remove from freqMap if no value for the count.
            if (keys.isEmpty()) {
                freqMap.remove(minFreq);
            }

            lfuCache.remove(evict);
        }

        Node newNode = new Node(value, 1);
        lfuCache.put(key, newNode);

        freqMap
            .computeIfAbsent(1, k -> new LinkedHashSet<>())
            .add(key);

        minFreq = 1;

    }

    private void updateFrequency(int key) {
    Node node = lfuCache.get(key);
    int currentFreq = node.freq;

    // remove from old freq set
    Set<Integer> oldSet = freqMap.get(currentFreq);
    oldSet.remove(key);

    if (oldSet.isEmpty()) {
        freqMap.remove(currentFreq);
        if (currentFreq == minFreq) {
            minFreq++;
        }
    }

    // increase freq
    node.freq++;
    int newFreq = node.freq;

    freqMap
        .computeIfAbsent(newFreq, k -> new LinkedHashSet<>())
        .add(key);
}

    class Node {
        int val;
        int freq;

        public Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */