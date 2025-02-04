class Solution {
    public int maxAscendingSum(int[] nums) {
        
        int max = nums[0], result = 0;
        boolean isFirst = true;

        for (int i = 1; i < nums.length; i++ ) {
            
            if (isFirst) {
                max = nums[i-1];
            }

            if (nums[i-1] < nums[i]) {
                max += nums[i];
                isFirst = false;
            } else {
                if (!isFirst) {
                    max = 0;
                    isFirst = true;
                }
            }

            result = Math.max(result, max);

        }

        return Math.max(result, max);

    }

}