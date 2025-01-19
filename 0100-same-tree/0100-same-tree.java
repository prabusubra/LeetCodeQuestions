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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
       Queue<TreeNode[]> queue = new LinkedList<>();

        queue.offer(new TreeNode[]{p, q});

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();

            TreeNode node0 = nodes[0];
            TreeNode node1 = nodes[1];

            if (node0 == null && node1 == null) continue;

            if (node0 == null || node1 == null || node0.val != node1.val) 
                return false;

           // if (node0.left != null && node1.left != null ) {
                queue.offer(new TreeNode[] {node0.left, node1.left});
           //}

            //if (node0.right != null && node1.right != null ) {
                queue.offer(new TreeNode[] {node0.right, node1.right});
            //}

        }

        return true;
    }
}