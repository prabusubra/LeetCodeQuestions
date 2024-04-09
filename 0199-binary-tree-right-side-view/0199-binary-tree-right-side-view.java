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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        
        if (root == null) return ls;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()){
            int parentSize = queue.size();
            
            for (int i =0; i < parentSize; i++){
                TreeNode node = queue.poll();
                if (null != node){
                    if (i == parentSize-1) ls.add(node.val);
                    if (null != node.left)
                        queue.add(node.left);
                    if (null != node.right)
                        queue.add(node.right);
                }
            }
        }
        
        return ls;
    }
}