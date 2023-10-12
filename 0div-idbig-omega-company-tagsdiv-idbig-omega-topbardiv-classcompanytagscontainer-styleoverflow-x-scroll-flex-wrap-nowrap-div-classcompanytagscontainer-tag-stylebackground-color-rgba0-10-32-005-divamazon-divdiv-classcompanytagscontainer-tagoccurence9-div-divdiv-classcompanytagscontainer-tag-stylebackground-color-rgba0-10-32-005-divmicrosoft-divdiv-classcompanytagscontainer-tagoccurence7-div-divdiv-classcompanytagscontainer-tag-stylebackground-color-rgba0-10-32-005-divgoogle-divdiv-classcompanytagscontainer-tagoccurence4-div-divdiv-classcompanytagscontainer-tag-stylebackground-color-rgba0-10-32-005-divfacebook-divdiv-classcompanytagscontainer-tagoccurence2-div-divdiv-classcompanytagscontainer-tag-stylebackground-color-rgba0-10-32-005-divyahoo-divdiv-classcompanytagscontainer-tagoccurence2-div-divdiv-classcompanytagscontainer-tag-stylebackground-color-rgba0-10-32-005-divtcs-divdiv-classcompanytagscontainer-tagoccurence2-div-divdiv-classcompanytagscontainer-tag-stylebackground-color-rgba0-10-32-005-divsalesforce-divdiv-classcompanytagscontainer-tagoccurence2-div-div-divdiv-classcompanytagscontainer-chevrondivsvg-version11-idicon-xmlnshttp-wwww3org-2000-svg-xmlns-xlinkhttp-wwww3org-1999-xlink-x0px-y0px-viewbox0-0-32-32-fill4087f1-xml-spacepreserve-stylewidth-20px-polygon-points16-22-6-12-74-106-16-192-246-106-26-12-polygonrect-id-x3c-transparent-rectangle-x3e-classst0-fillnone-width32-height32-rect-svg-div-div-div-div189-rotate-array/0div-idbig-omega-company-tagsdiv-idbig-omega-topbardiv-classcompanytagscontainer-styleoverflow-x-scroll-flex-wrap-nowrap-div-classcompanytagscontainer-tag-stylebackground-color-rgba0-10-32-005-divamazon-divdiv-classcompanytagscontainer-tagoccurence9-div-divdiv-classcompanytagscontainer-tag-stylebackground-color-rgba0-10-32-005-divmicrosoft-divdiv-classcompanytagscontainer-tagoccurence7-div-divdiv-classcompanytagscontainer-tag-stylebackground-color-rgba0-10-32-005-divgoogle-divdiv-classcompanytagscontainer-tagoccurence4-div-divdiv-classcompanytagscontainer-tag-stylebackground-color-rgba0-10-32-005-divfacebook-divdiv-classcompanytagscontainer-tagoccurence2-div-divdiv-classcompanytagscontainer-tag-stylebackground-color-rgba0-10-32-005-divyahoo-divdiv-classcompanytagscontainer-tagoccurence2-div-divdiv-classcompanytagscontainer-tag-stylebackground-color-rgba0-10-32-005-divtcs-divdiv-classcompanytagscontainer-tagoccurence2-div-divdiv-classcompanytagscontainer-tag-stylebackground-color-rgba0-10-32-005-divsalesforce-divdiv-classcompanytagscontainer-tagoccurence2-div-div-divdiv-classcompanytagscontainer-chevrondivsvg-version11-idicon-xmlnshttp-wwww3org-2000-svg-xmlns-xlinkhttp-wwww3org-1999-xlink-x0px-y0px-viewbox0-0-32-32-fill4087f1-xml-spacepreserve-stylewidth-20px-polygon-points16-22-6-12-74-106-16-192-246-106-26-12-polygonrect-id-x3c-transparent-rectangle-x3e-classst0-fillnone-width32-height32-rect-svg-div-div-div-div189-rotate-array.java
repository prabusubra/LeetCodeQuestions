class Solution {
    public void rotate(int[] nums, int k) {
        
        
        k= k%nums.length;
        if (nums.length > 1){
             for (int i=0, j=nums.length-1;i < j;i++,j--){
            
            int tmp = nums[i];
            
            nums[i] = nums[j];
            
            nums[j] = tmp;
            
        }
        
        for (int i=0, j=k-1;i < j; i++, j--){
            
            int tmp = nums[i];
            
            nums[i] = nums[j];
            
            nums[j] = tmp;
        }
        
        for (int i=k, j=nums.length-1;i < j; i++, j--){
            
            int tmp = nums[i];
            
            nums[i] = nums[j];
            
            nums[j] = tmp;
        }
        }
        
       

    }
    
    
}