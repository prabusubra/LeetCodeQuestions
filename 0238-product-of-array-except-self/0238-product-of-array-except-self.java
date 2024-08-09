class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
      //calculate left product
        ans[0] = 1;
        for (int i=1; i < nums.length;i++){
            ans[i] = nums[i-1]* ans[i-1];
        }
        
      // calculate right product
        int rp = 1;
        for (int i=nums.length-1; i >=0;i--){
            ans[i] = ans[i]*rp;
            rp = rp*nums[i];
        }
        
        return ans;
    }
}