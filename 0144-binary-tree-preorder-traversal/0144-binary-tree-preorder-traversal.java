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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        traversal(root, ls);
        return ls;
    }
    
    private void traversal(TreeNode node, List<Integer> ls){
        if (null == node) return;
        ls.add(node.val);
        traversal(node.left, ls);
        traversal(node.right, ls);
    }
}