class Solution {
    public int removeDuplicates(int[] nums) {
        int s = 0;
        
        for (int i=1;i < nums.length; i++){
            if (nums[s] != nums[i]){
                s++;
                if (s != i)
                    nums[s] = nums[i];
            }
        }
        return s+1;
    }
}
