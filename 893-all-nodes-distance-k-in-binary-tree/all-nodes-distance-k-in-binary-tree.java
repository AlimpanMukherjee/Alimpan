/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        ParentTrack(root, parent);

        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);

        int count = 0;

        while (!q.isEmpty()) {
            if (count == k) break;

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

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }
}
