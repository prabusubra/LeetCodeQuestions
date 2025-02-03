class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {

        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!used[i]){
                used[i] = true;
                curr.add(nums[i]);
                backtrack(nums, used, curr, res);
                curr.remove(curr.size()-1);
                used[i] = false;
            }


        }

    }
}