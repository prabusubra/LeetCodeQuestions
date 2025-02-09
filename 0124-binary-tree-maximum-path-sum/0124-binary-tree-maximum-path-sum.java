/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        
        if (root == null) return 0;

        int maxSum = Integer.MIN_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        Set<TreeNode> visited = new HashSet<>();

        Map<TreeNode, Integer> currSum = new HashMap<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
            } else {
                
                stack.pop();
                visited.add(node);
                int leftMax = currSum.getOrDefault(node.left, 0);
                int rightMax = currSum.getOrDefault(node.right, 0);

                leftMax = Math.max(leftMax, 0);
                rightMax = Math.max(rightMax, 0);

                int curr = node.val + leftMax + rightMax;

                maxSum = Math.max(maxSum, curr);

                currSum.put(node, node.val + Math.max(leftMax, rightMax));
            }
        }

        return maxSum;
    }
}