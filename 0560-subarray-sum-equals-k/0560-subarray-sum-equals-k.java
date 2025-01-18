class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> prefixMap = new HashMap<>();
        
        prefixMap.put(0, 1);
        //1,2,3
        int prefixSum = 0, total = 0;
        for (int i=0; i < nums.length; i++ ) {
            prefixSum += nums[i];

            if (prefixMap.containsKey(prefixSum - k)) {
                total += prefixMap.get(prefixSum - k); //1
            }

            prefixMap.compute(prefixSum, (k1, v) -> v!= null ? v+1: 1);
        }
        
        return total;
    }
}