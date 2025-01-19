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

        Queue<TreeNode[]> queue = new LinkedList<>();

        queue.offer(new TreeNode[]{nodeA, nodeB});

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();

            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];

            if (node1 == null && node2 == null)
                continue;
            
            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;

            queue.offer(new TreeNode[] {node1.left, node2.right});
            queue.offer(new TreeNode[] {node1.right, node2.left});

        }
        return true;
    }
}