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
    public int maxDepth(TreeNode root) {
        
        //based on nodes
        int height = 0;

        if (root == null) return height;

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            height++;

            int level = queue.size();

            for (int i = 0; i < level; i++ ) {
                TreeNode curr = queue.poll();

                if (curr.left != null ) queue.offer(curr.left);
                if (curr.right != null ) queue.offer(curr.right);
            }
        }

        return height;
    }
}