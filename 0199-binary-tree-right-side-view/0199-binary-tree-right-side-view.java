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
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);


        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i=0; i< levelSize; i++ ) {
                TreeNode node = queue.poll();

                //last element in the each level order is visible from right side
                if (i == levelSize-1)
                    result.add(node.val);

                if (node.left !=null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                
            }
        }

        return result;
    }
}