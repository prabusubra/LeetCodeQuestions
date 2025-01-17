class Solution {
    public boolean canPartition(int[] nums) {
       
       int total = 0;

        for (int num: nums) total += num;
        if (total % 2 != 0) return false;
       int sum = total/2;

       boolean[] dp = new boolean[sum +1];

        dp[0] = true;

       for (int num: nums) {
            for (int i = sum; i >= num; i-- ) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }


}