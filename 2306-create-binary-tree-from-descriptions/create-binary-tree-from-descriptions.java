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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<descriptions.length;i++)
        {
            int parent=descriptions[i][0];
            int child=descriptions[i][1];
            if(!map.containsKey(parent))
            {
                TreeNode a=new TreeNode();
                a.val=descriptions[i][0];
                map.put(descriptions[i][0],a);
            }
            if(!map.containsKey(child))
            {
                TreeNode a=new TreeNode();
                a.val=descriptions[i][1];
                map.put(a.val,a);
            }
            set.add(parent);
            set.add(child);
        }
        for(int i=0;i<descriptions.length;i++)
        {
            int parent=descriptions[i][0];
            int child=descriptions[i][1];
            int dir=descriptions[i][2];
            if(dir==1)
            {
                map.get(parent).left=map.get(child);
            }
            else if(dir==0)
            {
                map.get(parent).right=map.get(child);
            }
            set.remove(descriptions[i][1]);
        }
        int root=0;
        for(int i:set)
        {
            root=i;
        }
        return map.get(root);

    }
}