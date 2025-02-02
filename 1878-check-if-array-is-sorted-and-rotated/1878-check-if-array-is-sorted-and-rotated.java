class Solution {
    public boolean check(int[] nums) {
        
        int breakCounter = 0;
        for (int i =0; i < nums.length; i++ ) {
            if (nums[i] > nums[(i+1) % nums.length]) {
                breakCounter++;
            }
        }

        return breakCounter <= 1;
    }
}