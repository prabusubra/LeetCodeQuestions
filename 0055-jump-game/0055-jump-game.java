class Solution {
    public boolean canJump(int[] nums) {
        
        int max = 0;
        
        for (int i =0; i <nums.length;i++){
            
            if(i > max ) return false;
            
            int currentJump = i + nums[i];
            max = max > currentJump ? max : currentJump;
        }
        
        return true;
    }
}