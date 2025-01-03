class Solution {
    public int subarraySum(int[] nums, int k) {
               
        Map<Integer, Integer> counter = new HashMap<>();
        
        //counter.put(0, 1);
        
        int sum = 0, count = 0;
        for (int num: nums) {
           sum+= num;

           if (sum == k) count++;

           if (counter.containsKey(sum - k)) {
                count+= counter.get(sum - k);
           }

            counter.compute(sum, (k1,v) -> v!=null ? v +1: 1);
        }

        return count;
    }
}