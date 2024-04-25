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
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list.stream().filter(data -> data >= low && data <= high).reduce(0, (a,b) -> a +b);
    }
    
    private void traversal(TreeNode node, List<Integer> list){
        if (null == node) return;
        if (node.left != null) traversal(node.left, list);
        list.add(node.val);
        if (node.right != null) traversal(node.right, list);
    }
}