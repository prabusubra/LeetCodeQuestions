import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;

    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res) {
        
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num: nums) {
                temp.add(num);
            }
            res.add(temp);
            return;
        }

        for (int i =start; i < nums.length; i++ ) {
            swap(nums, i, start);
            backtrack(nums, start +1, res);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}