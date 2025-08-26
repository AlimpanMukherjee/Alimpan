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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode temp = list1;
        for (int i = 0; i < a - 1; i++) {
            temp = temp.next;
        }

        ListNode start = temp;
        System.out.println (start.val);
        
        for (int i = a; i <= b+1; i++) {
            temp = temp.next;
        }

        System.out.println(temp.val);
        

        
        ListNode temp2 = list2;
        while (temp2.next != null) {
             temp2 = temp2.next;
         }

         System.out.println(temp2.val);
        
        
        start.next=list2;
        temp2.next=temp;

        return list1;
    }
}
