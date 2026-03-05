class Solution {
    public int maxSubArray(int[] arr) {
        
        int result = arr[0], maxSum = arr[0];

        for (int i=1; i < arr.length; i++ ) {

            maxSum = Math.max(maxSum + arr[i], arr[i]);

            result = Math.max(result, maxSum);

        }

        return result;

    }
}