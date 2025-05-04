/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapNodes(struct ListNode* head, int k) {
    int n = 0;
    struct ListNode *p = head;
    
    // Count nodes
    while (p != NULL) {
        n++;
        p = p->next;
    }

    p = head;
    struct ListNode *first = NULL;
    struct ListNode *second = NULL;
    int i = 0;

    // Find the kth and (n-k+1)th nodes
    while (p != NULL) {
        if (i == k - 1) {
            first = p;
        }
        if (i == n - k) {
            second = p;
        }
        i++;
        p = p->next;
    }

    // Swap their values
    int t = first->val;
    first->val = second->val;
    second->val = t;

    return head;
}
