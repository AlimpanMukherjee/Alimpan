/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head)
    {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode nextnode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextnode;
        }
        head=prev;
        return head;
    }
    public int pairSum(ListNode head) {
        ListNode temp=head;
        ListNode fast=head;
        ListNode slow=head;
        if(head==null || head.next==null)return head.val;
        if(head.next.next==null)return (head.val+head.next.val);

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode left=head;
        ListNode right=slow.next;
        slow.next=null;
        right=reverseList(right);
        

        int sum=0;
        int max=Integer.MIN_VALUE;

        while(left!=null && right!=null)
        {
            sum=left.val+right.val;
            max=Math.max(sum,max);
            left=left.next;
            right=right.next;
        }

        return max;
    }
}