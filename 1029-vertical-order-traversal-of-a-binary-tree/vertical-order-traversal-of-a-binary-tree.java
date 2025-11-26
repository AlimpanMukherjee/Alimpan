class Solution {

    class Tuple {
        int x;
        int y;
        TreeNode node;

        Tuple(int row, int col, TreeNode n) {
            x = row;
            y = col;
            node = n;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        q.offer(new Tuple(0, 0, root));

        while (!q.isEmpty()) {
            Tuple t = q.poll();

            int x = t.x;
            int y = t.y;
            TreeNode n = t.node;

            if (!map.containsKey(x))
                map.put(x, new TreeMap<>());

            if (!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());

            map.get(x).get(y).offer(n.val);

            if (n.left != null)
                q.offer(new Tuple(x - 1, y + 1, n.left));

            if (n.right != null)
                q.offer(new Tuple(x + 1, y + 1, n.right));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> dummy = new ArrayList<>();

            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    dummy.add(pq.poll());
                }
            }

            ans.add(dummy);
        }

        return ans;
    }
}
