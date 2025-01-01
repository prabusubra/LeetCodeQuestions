class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
         Map<Integer, Integer> prefixsums = new HashMap<>();
        prefixsums.put(0, 1);

        int curr = 0, result = 0;

        for (int num: nums) {
            curr += num;

            int remainder = (curr % k + k)%k ;

           result += prefixsums.getOrDefault(remainder, 0);

            prefixsums.compute(remainder, (k1, v) -> v != null ? v +1 : 1);
        }

        return result;

    }
}