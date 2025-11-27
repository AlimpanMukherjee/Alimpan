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
    void find(ArrayList<Integer> ans,TreeNode root,int level)
    {
        if(root==null)return;
        if(level==ans.size())ans.add(root.val);
        find(ans,root.right,level+1);
        find(ans,root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        find(ans,root,0);
        return ans;
    }
}