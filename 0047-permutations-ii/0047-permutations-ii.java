class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);

        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);

        return result;

    }

    private static void backtrack(int[] nums, List<Integer> curr, 
                                    List<List<Integer>> result,
                                    boolean[] used) {
        
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++ ) {
            boolean duplicate = i > 0 && nums[i] == nums[i-1] && used[i-1];
            if (!used[i] && !duplicate) {
                used[i] = true;
                curr.add(nums[i]);
                backtrack(nums, curr, result, used);
                curr.remove(curr.size()-1);
                used[i] = false;
            }

        }

    }
}