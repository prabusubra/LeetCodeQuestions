class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        sort(nums);

        for (int i = 0; i < nums.length; i++ ) {
            if (nums[i] != i+1) {
                result.add(nums[i]);
            }
        }

        return result;
    }

    private static void sort(int[] arr) {
        int i = 0, n = arr.length;
        while (i < n) {
            int currIndex = arr[i] -1;
            if (arr[i] != arr[currIndex]) {
                int tmp = arr[i];
                arr[i] = arr[currIndex];
                arr[currIndex] = tmp;
            } else i++;
        }
    }
}