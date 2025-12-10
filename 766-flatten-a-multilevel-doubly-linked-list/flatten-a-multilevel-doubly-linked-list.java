/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node prev=null;
    public void helper(Node head)
    {
        if(head==null)return;
        
        helper(head.next);
        helper(head.child);
        head.next=prev;
        if(head.next!=null)head.next.prev=head;
        prev=head;
        head.child=null;
    }
    public Node flatten(Node head) {
        helper(head); 
        return head;

    }
}