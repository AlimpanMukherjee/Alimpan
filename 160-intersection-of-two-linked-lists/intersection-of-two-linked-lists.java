/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        while(true)
        {
            if(temp1==temp2)return temp1;
            temp1=temp1.next;
            temp2=temp2.next;

            if(temp1==null && temp2==null)return null;

            if(temp1==null)temp1=headB;
            if(temp2==null)temp2=headA;
            
        }
        
    }
}