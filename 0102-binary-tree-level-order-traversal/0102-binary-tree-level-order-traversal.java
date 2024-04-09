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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> result1 = new ArrayList<>();
            for (int i =0; i < size; i++){
                TreeNode current = queue.poll();
                if (null != current ){
                    if (null != current.left)
                        queue.add(current.left);
                    if (null != current.right)
                        queue.add(current.right);
                    result1.add(current.val);
                }
                  
                
            }
             result.add(result1);
        }
       
        return result;
    }
}