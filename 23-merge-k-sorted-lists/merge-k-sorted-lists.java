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
import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Use ListNode instead of Node, and Comparator spelled correctly
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (ListNode n : lists) {
            if (n != null) pq.add(n);
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode newnode = pq.poll();
            if (newnode.next != null) pq.add(newnode.next);
            temp.next = newnode;
            temp = temp.next;
        }

        return dummy.next;
    }
}
