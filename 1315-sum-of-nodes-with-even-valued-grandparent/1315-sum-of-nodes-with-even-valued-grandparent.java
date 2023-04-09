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
    public int sumEvenGrandparent(TreeNode root) {
        return counter(root);
    }

    private int counter(TreeNode node){
        int sum = 0;
        if (node == null) return 0;
        if (node != null){
            if (node.val % 2 == 0){
                if (node.left != null && node.left.left != null){
                    sum+= node.left.left.val;
                }
                 if (node.left != null && node.left.right != null){
                    sum+= node.left.right.val;
                }
                 if (node.right != null && node.right.left != null){
                    sum+= node.right.left.val;
                }
                 if (node.right != null && node.right.right != null){
                    sum+= node.right.right.val;
                }
            }
        }
        sum+=counter(node.left) + counter(node.right);
        return sum;
    }
}