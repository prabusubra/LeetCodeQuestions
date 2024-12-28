class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[3];

        // Step 1: Compute the sum of all windows of size k
        int[] windowSums = new int[n - k + 1];
        int windowSum = 0;
        for (int i = 0; i < n; i++) {
            windowSum += nums[i];
            if (i >= k - 1) {
                windowSums[i - k + 1] = windowSum;
                windowSum -= nums[i - k + 1];
            }
        }

        // Step 2: Compute the best indices for one subarray on the left
        int[] left = new int[windowSums.length];
        int bestLeft = 0;
        for (int i = 0; i < windowSums.length; i++) {
            if (windowSums[i] > windowSums[bestLeft]) {
                bestLeft = i;
            }
            left[i] = bestLeft;
        }

        // Step 3: Compute the best indices for one subarray on the right
        int[] right = new int[windowSums.length];
        int bestRight = windowSums.length - 1;
        for (int i = windowSums.length - 1; i >= 0; i--) {
            if (windowSums[i] >= windowSums[bestRight]) {
                bestRight = i;
            }
            right[i] = bestRight;
        }

        // Step 4: Find the maximum sum of three subarrays
        int maxSum = 0;
        for (int j = k; j < windowSums.length - k; j++) {
            int leftIndex = left[j - k];
            int rightIndex = right[j + k];
            int totalSum = windowSums[leftIndex] + windowSums[j] + windowSums[rightIndex];
            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = leftIndex;
                result[1] = j;
                result[2] = rightIndex;
            }
        }

        return result;
    }
}