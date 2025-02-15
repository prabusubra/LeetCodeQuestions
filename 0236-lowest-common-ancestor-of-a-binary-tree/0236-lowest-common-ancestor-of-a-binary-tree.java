/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }


        }

        Set<TreeNode> ansestors = new HashSet<>();

        while (p != null) {
            ansestors.add(p);
            p = parentMap.get(p);
        }


        while (!ansestors.contains(q)) {
            q = parentMap.get(q);
        }

        return q;

    }
}