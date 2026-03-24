class Solution {
    public double findMaxAverage(int[] nums, int k) {
          int result = 0, windowSum = 0;

        for (int i = 0; i < k; i++)
            windowSum += nums[i];

        result = windowSum;
        //window starts here

        for (int i=k; i < nums.length; i++ ) {

            windowSum =  windowSum + nums[i]  - nums[i-k];

            result = Math.max(result, windowSum);

        }

        return (double)result/k;
    }
}