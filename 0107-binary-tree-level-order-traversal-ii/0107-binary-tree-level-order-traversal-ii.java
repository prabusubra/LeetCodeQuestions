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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null != root){
             Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);

            while(!queue.isEmpty()){
                int qSize = queue.size();
                List<Integer> data = new ArrayList<Integer>();
                int index = 0;
                while (index < qSize){
                    TreeNode temp = queue.remove();
                    data.add(temp.val);
                    if (null != temp.left){
                        queue.add(temp.left);
                    }
                if (null != temp.right){
                    queue.add(temp.right);
                }
                index++;
            }
            result.add(data);
        }
        }
       Collections.reverse(result);
        return result;
        
    }
}