/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// class Solution {
//     public Node connect(Node root) {
        
//     }
// }






class Solution {
    public Node connect(Node root) {

        if (root == null) return null;   
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        List<List<Node>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Node> dummy = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node t = q.poll();
                dummy.add(t);

                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            ans.add(dummy);
        }
        for (List<Node> ls : ans) {
            for (int i = 0; i < ls.size(); i++) {
                Node n = ls.get(i);
                Node n1;
                if (i + 1 < ls.size()) n1 = ls.get(i + 1);
                else n1 = null;
                n.next = n1;
            }
        }

        return root; 
    }
}
