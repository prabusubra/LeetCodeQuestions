class Solution {
    public int findMin(int[] nums) {
        
        int start = 0, end = nums.length-1;

        while (start <= end) {
            
            //if sorted
            if (nums[start] <= nums[end]) {
                return nums[start];
            }

            //find mid

            int mid = (start+end)/2;
            //if sorted
            if (nums[mid] < nums[end]) {
                end = mid;
            } else { // mid > end
                start = mid+1;
            }

        }
        return -1;
    }
}