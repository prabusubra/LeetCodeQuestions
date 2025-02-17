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
        
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode tmpNode = queue.poll();
                
                temp.add(tmpNode.val);

                if (tmpNode.left != null)
                    queue.add(tmpNode.left);
                
                if (tmpNode.right != null)
                    queue.add(tmpNode.right);
            }
            result.add(temp);
        }
        return result;
    }
}