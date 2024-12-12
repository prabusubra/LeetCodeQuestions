class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, comb, result);
        return result;

    }

    private static void backtrack(int[] cand, int target, int start, List<Integer> comb, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < cand.length; i++) {

            if ( cand[i] <= target) {
                comb.add(cand[i]);

                backtrack(cand, target - cand[i], i, comb, res);

                comb.remove(comb.size()-1);
            }

        }
    }
}