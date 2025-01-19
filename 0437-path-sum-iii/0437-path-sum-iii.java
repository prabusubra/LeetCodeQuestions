class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1);

        return dfs(root, targetSum, prefixMap, 0L);

    }

    private int dfs(TreeNode node, int target, Map<Long, Integer> prefixes, long curr) {

        if (node == null) return 0;

        curr += node.val;

        int count  = prefixes.getOrDefault(curr - target, 0);

        prefixes.compute(curr, (k, v) -> v != null ? v+1:1);

        count += dfs(node.left, target, prefixes, curr);

        count += dfs(node.right, target, prefixes, curr);

        prefixes.compute(curr, (k, v) -> v-1);

        return count;
    }
}