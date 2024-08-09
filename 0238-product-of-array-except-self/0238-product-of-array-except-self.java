class Solution {
    public int[] productExceptSelf(int[] nums) {
       
        int zero = 0, product=1;
        for (int a : nums)
            if (a == 0)
                zero++;
            else 
                product*=a;
        
        int[] ans = new int[nums.length];
        
        for (int i=0; i< nums.length;i++){
            if (zero> 1) ans[i]=0;
            else if (zero == 1){
                 if (nums[i] == 0) {
                     ans[i] = product;
                 } else  ans[i]=0;
            }
            else ans[i] = product/nums[i];
        }
        return ans;
    }
}