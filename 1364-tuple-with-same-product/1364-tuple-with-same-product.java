class Solution {
    public int tupleSameProduct(int[] nums) {
        
        Map<Integer, Integer> counter = new HashMap<>();

        int n = nums.length;

        for (int i=0; i < n-1; i++ ) {
            for (int j = i+1; j < n; j++ ) {
                
                int tmp = nums[i]* nums[j];

                counter.compute(tmp, (k,v) -> v != null ? v +1 : 1);

            }
        }

        int count = 0;

        for (int val: counter.values()) {
            count += 8 * ncr(val);
        }

        return count;

    }

    private static int ncr(int n) {
        return (n*(n-1)/2);
    }
}