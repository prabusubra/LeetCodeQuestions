class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        //2,5,6,8,12,15

        int min = Integer.MAX_VALUE, sum = 0, left = 0;

        for (int i=0; i < nums.length; i++ ) {
            
            sum += nums[i];

            while ( sum >= target ) {

                min = Math.min(min, i - left +1);
                sum -= nums[left++];

            }
        }

        return min == Integer.MAX_VALUE ? 0: min;

    }
}