class Solution {
    public ListNode findkth(ListNode head, int k) {
        k -= 1;
        ListNode temp = head;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode nextnode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextnode;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp = head;

        while (temp != null) {
            ListNode kth = findkth(temp, k);
            if (kth == null) {
                prev.next = temp;
                break;
            }

            ListNode newnode = kth.next;
            kth.next = null;

            ListNode revHead = reverse(temp);
            prev.next = revHead;
            temp.next = newnode;

            prev = temp;
            temp = newnode;
        }

        return dummy.next;
    }
}
