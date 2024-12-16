class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        PriorityQueue<Integer> heap = 
        new PriorityQueue<>((i, j) -> nums[i] == nums[j] ? i-j : nums[i] - nums[j]);

        for (int i = 0; i < nums.length; i++) heap.offer(i);

        while (k-- >0) {
            int i = heap.poll();
            nums[i] *= multiplier;
            heap.offer(i);
        }

        return nums;
    }
}