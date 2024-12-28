class Solution {
    public int findDuplicate(int[] nums) {
        sort(nums);

        for (int i=0; i < nums.length; i++ ) {
            if (nums[i] != i +1) return nums[i];
        }
        return 0;
    }

    private static void sort(int[] arr) {
        int i = 0, n = arr.length;
        while (i < n) {
            
            int currIndex = arr[i] -1;

            if (arr[i] <= n && arr[i] != arr[currIndex]) {
                int tmp = arr[i];
                arr[i] = arr[currIndex];
                arr[currIndex] = tmp;
            } else i++;

        }

    }
}