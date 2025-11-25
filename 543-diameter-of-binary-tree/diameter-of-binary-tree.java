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
    public int maxi=0;
    int find(TreeNode root)
    {
        if(root==null)return 0;
        int lh=find(root.left);
        int rh=find(root.right);
        maxi=Math.max(maxi,lh+rh);
        return 1+Math.max(lh,rh);        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int n=find(root);
        return maxi;

    }
}