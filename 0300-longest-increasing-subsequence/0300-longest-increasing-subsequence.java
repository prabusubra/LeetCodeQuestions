class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int maxLength = 1;
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++ ) {
            for (int j = 0; j < i; j++ ) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}