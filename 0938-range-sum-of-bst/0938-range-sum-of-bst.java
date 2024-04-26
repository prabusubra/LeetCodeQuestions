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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return traversal(root, low, high);
    }
    
    private int traversal(TreeNode node, int low, int high){
       if (node == null) return 0;
        if (node.val < low) return traversal(node.right, low, high);
        if (node.val > high) return traversal(node.left, low, high);
        return node.val + traversal(node.left, low, high) + traversal(node.right, low, high);
    }
}