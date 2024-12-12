class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, new ArrayList<>(), res, 1);
        return res;

    }

    private static void backtrack(int n , int k, List<Integer> curr, List<List<Integer>> res, int start) {

        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++ ) {
            curr.add(i);
            backtrack(n, k, curr, res, i + 1);
            curr.remove(curr.size()-1);
        }

    }
}