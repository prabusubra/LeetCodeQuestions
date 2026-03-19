class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int num: nums) {
            freqCount.put(num, freqCount.getOrDefault(num, 0) +1);
        }
        
        PriorityQueue<Integer> heap = 
        new PriorityQueue<>(Comparator.comparingInt(freqCount::get));

        for (int n: freqCount.keySet()) {
            heap.offer(n);

            if (heap.size() > k) heap.poll();
        }
        
        int[] res = new int[k];

        for (int i = 0; i < k; i++ ) {
            res[i] = heap.poll();
        }

        return res;
    }
}