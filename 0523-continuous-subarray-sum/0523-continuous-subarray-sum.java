class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       
       if (nums.length < 2) return false;

       Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        prefixSumMap.put(0, -1);
       
       boolean result = false;
       int prefixSum = 0;

       for (int i = 0; i < nums.length; i++ ) {
            prefixSum += nums[i];

            int rem = prefixSum % k;
            if (prefixSumMap.containsKey(rem)) {
                int start = prefixSumMap.get(rem);

                int len = (i - start);

                if (len >1) {
                    result = true;
                    break;
                }
            } else prefixSumMap.put(rem, i);

       }
        return result;
    }
}
