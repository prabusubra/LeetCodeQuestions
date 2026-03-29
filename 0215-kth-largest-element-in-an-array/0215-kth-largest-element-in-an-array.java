class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int num: nums) {
            queue.offer(num);

            if (queue.size() > k) {
                queue.remove();
            }

        }

        return queue.peek();
    }
}