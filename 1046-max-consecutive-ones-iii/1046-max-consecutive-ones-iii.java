class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int left = 0, result = 0, noOfZeros = 0;

        for (int i = 0; i < nums.length; i++ ) {

            if (nums[i] == 0) noOfZeros++;

            while (noOfZeros > k) {
                if (nums[left] == 0) {
                    noOfZeros--;
                }
                left++;
            }

            result = Math.max(result, i - left +1);

        }

        return result;

    }
}