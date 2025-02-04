class Solution {
    public int maxAscendingSum(int[] nums) {
        
       int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < nums.length; i++ ) {

            if (nums[i-1] < nums[i]) {
                currSum += nums[i];
            } else {
                currSum = nums[i];
            }

            maxSum = Math.max(maxSum, currSum);

        }

       return maxSum;

    }

}