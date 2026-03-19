class LFUCache {

    private int capacity;
    private Map<Integer, Set<Integer>> frequencyMap;
    private Map<Integer, Node> lfuCache;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.frequencyMap = new HashMap<>();
        this.frequencyMap.put(1, new LinkedHashSet<>());
        this.lfuCache = new HashMap<>();


    }
    
    public int get(int key) {
        if (!lfuCache.containsKey(key)) {
            return -1;
        }

        Node node = lfuCache.get(key);
        int currentFreq = node.freq;

        // remove from old freq
        Set<Integer> oldSet = frequencyMap.get(currentFreq);
        oldSet.remove(key);
        if (oldSet.isEmpty()) {
            frequencyMap.remove(currentFreq);
            if (currentFreq == minFreq) {
                minFreq++;
            }
        }

        // increase freq
        node.freq++;
        int newFreq = node.freq;

        frequencyMap.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(key);

        return node.val;

    }
    
    public void put(int key, int value) {
        
        if (capacity == 0) return;

        if (lfuCache.containsKey(key)) {
            Node node = lfuCache.get(key);
            node.val = value;
            get(key); // reuse logic
            return;
        }

        if (lfuCache.size() == capacity) {
            Set<Integer> keys = frequencyMap.get(minFreq);
            int evict = keys.iterator().next();

            keys.remove(evict);
            if (keys.isEmpty()) {
                frequencyMap.remove(minFreq);
            }

            lfuCache.remove(evict);
        }

        Node newNode = new Node(value, 1);
        lfuCache.put(key, newNode);

        frequencyMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;

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