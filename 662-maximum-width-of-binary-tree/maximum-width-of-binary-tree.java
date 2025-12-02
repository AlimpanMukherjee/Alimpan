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
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode n,int i)
        {
            node=n;
            index=i;
        }

    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<Pair>();
        q.offer(new Pair(root,1));
        int maxwidth=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            int min=q.peek().index;
            int first=0,last=0;
            for(int i=0;i<size;i++)
            {
                Pair p=q.poll();
                TreeNode node=p.node;
                int currindex=p.index-min;
                if(i==0)first=currindex;
                if(i==size-1)last=currindex;
                maxwidth=Math.max(maxwidth,currindex-min);
                if(node.left!=null)q.offer(new Pair(node.left,currindex*2+1));
                if(node.right!=null)q.offer(new Pair(node.right,currindex*2+2));
            }
            maxwidth=Math.max(maxwidth,last-first+1);
        }
        return maxwidth;
    }
}