/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        
        while(temp!=null)
        {
            Node copynode=new Node(temp.val);
            copynode.next=temp.next;
            temp.next=copynode;
            temp=copynode.next;
        }

        temp=head;
        while(temp!=null)
        {
            Node copynode=temp.next;
            if(temp.random!=null)copynode.random=temp.random.next;
            temp=temp.next.next;
        }

        Node dummy=new Node(-1);
        Node res=dummy;

        temp=head;
        while(temp!=null)
        {
            res.next=temp.next;
            res=res.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}