class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num: nums) sum += num;

        if (sum % 2 != 0) return false;

        int[][] memo = new int[nums.length][sum+1];

        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }

        return backtrack(nums, nums.length, sum/2, memo);
    }

    private static boolean backtrack(int[] nums, int index, int sum, int[][] memo) {
        
        if (sum == 0) return true;

        if (index == 0) return false;
        
        if (memo[index-1][sum] != -1) return memo[index-1][sum] == 1;
        
        int result = 0;
        if (nums[index -1] > sum) {
            return backtrack(nums, index-1, sum, memo);
        }

        memo[index-1][sum] = (backtrack(nums, index-1, sum, memo) 
        || backtrack(nums, index-1, sum- nums[index-1], memo)) ? 1:0;

        return memo[index-1][sum] == 1;
    }
}