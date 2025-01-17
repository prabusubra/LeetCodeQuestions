class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int maxLength = 1;
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int curr = 1; curr < nums.length; curr++ ) {
            for (int prev = 0; prev < curr; prev++ ) {
                if (nums[prev] < nums[curr]) {
                    dp[curr] = Math.max(dp[curr], dp[prev] +1);
                }
            }
            maxLength = Math.max(maxLength, dp[curr]);
        }

        return maxLength;
    }
}