/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */


func diameterOfBinaryTree(root *TreeNode) int {
    diameter := 0
    height(root, &diameter);

    return diameter

}

func height(node *TreeNode, diameter *int) int {
    if node == nil {
        return 0
    }

    left := height(node.Left, diameter)
    right := height(node.Right, diameter)

    currdiameter := left + right

    if currdiameter > *diameter {
        *diameter = currdiameter
    } 

    currheight := left

    if right > currheight {
        currheight = right
    }

    return currheight +1;
}