class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;

        sort(nums);

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return n + 1;
        
    }

    private static void sort(int[] arr) {
        int i = 0;
        while ( i < arr.length) {
            int currIndex = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[currIndex]) {
                int tmp = arr[i];
                arr[i] = arr[currIndex];
                arr[currIndex] = tmp;
                
            } else {
                i++;
            }
        }
    }
}
