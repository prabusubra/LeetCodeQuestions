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
    public TreeNode searchBST(TreeNode root, int val) {
        return traverse(root, val);
    }

    public TreeNode traverse(TreeNode root, int val){
        if (root == null) return null;
        else if (root.val > val) return traverse(root.left, val);
        else if(root.val < val) return traverse(root.right, val);
        else return root;
    }
}