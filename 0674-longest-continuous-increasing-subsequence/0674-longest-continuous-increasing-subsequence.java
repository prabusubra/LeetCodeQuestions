class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int maxLen = 1, currLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1])
                currLen += 1;
            else currLen = 1;
            maxLen = Math.max(maxLen, currLen);
        }
        
        return maxLen;
    }
}