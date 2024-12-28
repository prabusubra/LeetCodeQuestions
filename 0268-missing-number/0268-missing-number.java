class Solution {
    public int missingNumber(int[] nums) {
        performCyclicSort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    private static void performCyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i];
            if (correctIndex < arr.length && arr[i] != arr[correctIndex]) {
                int tmp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = tmp;
            } else i++;
        }

    }
}