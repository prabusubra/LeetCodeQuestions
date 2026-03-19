class Solution {
    public int maxSubArray(int[] arr) {
        
        int result = arr[0], max = arr[0];

        for (int i=1; i < arr.length; i++ ) {

            max = Math.max(max + arr[i], arr[i]);

            result = Math.max(result, max);

        }

        return result;

    }
}