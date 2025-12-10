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
    TreeNode find(TreeNode root) {
    while (root.left != null) {
        root = root.left;
    }
    return root;  
}

    TreeNode helper(TreeNode root) {


    if (root.right == null)
        return root.left;

    else if (root.left == null)return root.right;
    else {    
    TreeNode rightChild = root.right;
    TreeNode leftChild = root.left;

    TreeNode leftOfRight = find(root.right); 
    leftOfRight.left = leftChild;  
    
    return rightChild;
    }

}
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) return helper(root);

        TreeNode curr = root;

        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                }
                curr = curr.right;
            }
        }

        return root;
    }
}
