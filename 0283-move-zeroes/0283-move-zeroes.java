class Solution {
    public void moveZeroes(int[] nums) {
        

        //1,0
        int j = 0;
        for (int i=0; i < nums.length; i++ ) {
            
            if (i != j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            
            if (nums[j] != 0) {
                j++;
            }
            
            
        }

    }
}