class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode a = q.poll();

                if (a.left != null) q.offer(a.left);
                if (a.right != null) q.offer(a.right);

                sub.add(a.val);
            }
            List<Integer> dummy = new ArrayList<>();
            for (int x : sub) {
                if (leftToRight) dummy.add(x);
                else dummy.add(0, x); 
            }

            ans.add(dummy);
            leftToRight = !leftToRight;
        }

        return ans;
    }
}
