class Solution {
    public boolean canJump(int[] nums) {
        
        int curr = nums[0];

        for (int i = 1; i < nums.length; i++ ) {

            if (curr < i) return false;

            curr = Math.max(curr, i + nums[i]);

            if (curr >= nums.length) return true;

        }
        
        return true;
    }
}