class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> prefixMap = new HashMap<>();

        prefixMap.put(0, -1);

        int prefixSum = 0, result =0;

        for (int i =0; i < nums.length; i++ ) {
            prefixSum += (nums[i] == 0 ? -1 :1);

            if (prefixMap.containsKey(prefixSum) ) {
                result = Math.max(result, i - prefixMap.get(prefixSum));
            } else prefixMap.put(prefixSum, i);
            
        }

        return result;
    }
}