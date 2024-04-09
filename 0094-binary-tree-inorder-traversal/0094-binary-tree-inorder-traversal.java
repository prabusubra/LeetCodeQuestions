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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        traversal(root, ls);
        return ls;
    }
    
    private void traversal(TreeNode node, List<Integer> ls){
        if (null == node) return;
        traversal(node.left, ls);
        ls.add(node.val);
        traversal(node.right, ls);
    }
    
}