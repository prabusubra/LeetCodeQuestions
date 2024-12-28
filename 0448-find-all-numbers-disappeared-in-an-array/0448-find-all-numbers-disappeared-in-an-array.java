class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i +1) {
               result.add(i+1); 
            }
        }

        return result;

    }

    private static void sort(int[] arr) {

        int i = 0, n = arr.length;

        while (i < n) {

            int corrIndex = arr[i] - 1;

            if (arr[i] <= n && arr[i] != arr[corrIndex]) {
                int tmp = arr[i];
                arr[i] = arr[corrIndex];
                arr[corrIndex] = tmp;
            } else i++;

        }

    } 
}