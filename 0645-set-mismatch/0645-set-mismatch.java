class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        sort(nums);
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            if (nums[i] != i +1) {
                res[0] = nums[i];
                res[1] = i +1;
                break;
            }
        }

        return res;
    }

    private static void sort(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            int j = nums[i] -1;
            if (nums[i] != nums[j]) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else i++;
        } 
    }
}