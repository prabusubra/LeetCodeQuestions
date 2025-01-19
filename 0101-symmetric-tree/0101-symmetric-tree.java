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
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode nodeA, TreeNode nodeB) {
         Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(nodeA);
    queue.offer(nodeB);

    while (!queue.isEmpty()) {
        TreeNode node1 = queue.poll();
        TreeNode node2 = queue.poll();

        // Both nodes are null, continue to next pair
        if (node1 == null && node2 == null) continue;

        // If one node is null or values differ, the tree is not symmetric
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        // Add children in mirrored order to the queue
        queue.offer(node1.left);
        queue.offer(node2.right);
        queue.offer(node1.right);
        queue.offer(node2.left);
    }

    return true;
    }
}