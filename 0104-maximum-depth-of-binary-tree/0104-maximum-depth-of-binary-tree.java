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
        return check(root);
    }
    
    public int check(TreeNode node){
        if (node ==null) {return 0;}
        int a = check(node.left);
        int b = check(node.right);
        return 1 + Math.max(a,b);
        
    }
}