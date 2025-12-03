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
        public void ParentTrack(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode n = q.poll();

            if (n.left != null) {
                q.offer(n.left);
                parent.put(n.left, n);
            }
            if (n.right != null) {
                q.offer(n.right);
                parent.put(n.right, n);
            }
        }
    }
    public TreeNode find(TreeNode root,int start)
    {
       Queue<TreeNode> q=new LinkedList<>();
       q.offer(root);
       while(!q.isEmpty())
       {
        TreeNode n=q.poll();
        if(n.val==start)return n;
        if(n.left!=null)q.offer(n.left);
        if(n.right!=null)q.offer(n.right);
       } 
       return null;
    }
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        ParentTrack(root, parent);

        Set<TreeNode> visited = new HashSet<>();
        TreeNode target=find(root,start);
        q.offer(target);
        visited.add(target);

        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode n = q.poll();

                if (n.left != null && !visited.contains(n.left)) {
                    visited.add(n.left);
                    q.offer(n.left);
                }

                if (n.right != null && !visited.contains(n.right)) {
                    visited.add(n.right);
                    q.offer(n.right);
                }

                if (parent.get(n) != null && !visited.contains(parent.get(n))) {
                    visited.add(parent.get(n));
                    q.offer(parent.get(n));
                }
            }

            count++;
        }
        return count-1;
    }
}




