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
    List<Double> levelSum = new ArrayList<>(); 
    List<Integer> levelCount = new ArrayList<>(); 

    public void traverse(TreeNode root, int depth){
        if(root==null){
            return; 
        }

        if(depth>=levelSum.size()){
            levelSum.add((double)root.val); 
            levelCount.add(1); 
        }else{
            levelSum.set(depth, levelSum.get(depth)+root.val); 
            levelCount.set(depth, levelCount.get(depth)+1); 
        }

        traverse(root.left, depth+1); 
        traverse(root.right, depth+1); 
    }
    public List<Double> averageOfLevels(TreeNode root) {
        traverse(root, 0); 

        List<Double> ans = new ArrayList<>(); 

        for(int i = 0; i<levelSum.size(); i++){
            ans.add(levelSum.get(i)/levelCount.get(i)); 
        }

        return ans; 
    }
}