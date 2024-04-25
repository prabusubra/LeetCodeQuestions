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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        AtomicLong min = new AtomicLong(Long.MIN_VALUE);
        return list.stream().allMatch(d -> d > min.getAndSet(d));
    }

    private void traverse(TreeNode node, List<Integer> list){
        if (node == null) return;
        if (node.left != null) traverse(node.left, list);
        list.add(node.val);
        if (node.right != null) traverse(node.right, list);
        
    }
}