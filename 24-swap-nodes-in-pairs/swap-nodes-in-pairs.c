struct ListNode* swapPairs(struct ListNode* head) {
    if (head == NULL || head->next == NULL) {
        return head; // No pairs to swap
    }

    struct ListNode* p = head;
    struct ListNode* temp;
    struct ListNode *q;
    head = head->next; // The new head will be the second node

    while (p != NULL && p->next != NULL) {
        temp = p->next;   // Store second node in the pair
        p->next = temp->next; // Point first node to the next pair
        temp->next = p;    // Swap nodes

        q=p;
        p = p->next; // Move p to the next pair
        if(q->next!=NULL && q->next->next!=NULL)
        {
            q->next=q->next->next;
        }
    }

    return head;
}
