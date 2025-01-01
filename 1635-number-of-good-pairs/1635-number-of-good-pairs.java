class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        Map<Integer, Integer> mapping = new HashMap<>();

        int result = 0;
        for (int i = 0; i < nums.length; i++ ) {
            if (mapping.containsKey(nums[i])) {
                result += mapping.get(nums[i]);
            }

            mapping.compute(nums[i], (k, v) -> v == null ? 1 : v+1);

        }

        return result;
    }
}