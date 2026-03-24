class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> counter = new HashMap<>();

        long sum = 0L, result = 0L;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }

        if (counter.size() == k) result = sum;

        for (int i=k; i < nums.length; i++ ) {

            int include = nums[i];
            int remove = nums[i-k];

            int cr = counter.get(remove);
            if (cr == 1) counter.remove(remove);
            else counter.put(remove, counter.getOrDefault(remove, 0) -1);
            sum -= remove;

            counter.put(include, counter.getOrDefault(include, 0) +1);
            sum += include;

            if (counter.size() == k) result = Math.max(result, sum);

        }
        
        return result;
    }
}