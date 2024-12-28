class Solution {
    public int missingNumber(int[] nums) {
        sort(nums);
        int n = nums.length;
        for (int a: nums) System.out.println("a "+a);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    private static void sort(int[] arr) {
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