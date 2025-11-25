
class Solution {
    int mp = 0; 
    int dfs(TreeNode node) {
        if (node == null) return 0; 
        int leftPath = 0, rightPath = 0;
        int ls=dfs(node.left);
        int rs=dfs(node.right); 
        if (node.left != null && node.left.val == node.val) {
            leftPath =ls + 1;
        }
        
        if (node.right != null && node.right.val == node.val) {
            rightPath =rs + 1;
        }
        
        mp = Math.max(mp, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

    public int longestUnivaluePath(TreeNode root) {
        mp = 0;
        dfs(root);
        return mp;
    }
}
