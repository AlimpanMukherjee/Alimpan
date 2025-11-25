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
    public int maxsum=Integer.MIN_VALUE;
    int find(TreeNode root)
    {
        if(root==null)return 0;
        int ls=find(root.left);
        int rs=find(root.right);
        if(ls<0 && rs<0) maxsum=Math.max(maxsum,root.val);
        else if(ls<0) maxsum=Math.max(maxsum,rs+root.val);
        else if(rs<0) maxsum=Math.max(maxsum,ls+root.val);
        else maxsum=Math.max(maxsum,ls+rs+root.val);
        if(ls>0 && rs>0)return root.val+Math.max(ls,rs);
        else if(ls>0)return root.val+ls;
        else if(rs>0)return root.val+rs;
        else return root.val;
        
    }
    public int maxPathSum(TreeNode root) {
        int n=find(root);
        return maxsum;
    }
}