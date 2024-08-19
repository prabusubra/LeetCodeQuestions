class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int m = 0, j=0;
        for (int i=0; i < nums.length; i++){
            if (nums[i] ==1){
                j++;
            } else {
                j=0;
            }
            m = Math.max(j, m);
        }
        return m;
    }
}