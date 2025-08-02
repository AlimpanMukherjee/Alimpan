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
        public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode temp = head;
        ListNode next = null;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newhead=slow.next;
        ListNode first=head;
        newhead=reverseList(newhead);
        ListNode sec=newhead;
        while(sec!=null)
        {
            if(sec.val!=first.val)return false;
            first=first.next;
            sec=sec.next;
        }
        return true;
    }
}