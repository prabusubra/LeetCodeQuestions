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

    var height func(node *TreeNode) int

    height = func(node *TreeNode) int {
    if node == nil {
        return 0
    }

    left := height(node.Left)
    right := height(node.Right)

    currdiameter := left + right

    if currdiameter > diameter {
        diameter = currdiameter
    } 

    currheight := left

    if right > currheight {
        currheight = right
    }

    return currheight +1;


    }
    height(root);

    return diameter

}
