/**
 * Definition for singly-linked list.
 * struct LisNtode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeNodes(struct ListNode* head) {
    struct ListNode *p=head->next;
    head=head->next;
    // if(head->next==NULL)
    // {
    //     return head;
    // }
    while(p!=NULL)
    {
        struct ListNode *temp=p;
        while(p->val!=0)
        {
            p=p->next;
            temp->val+=p->val;
        }
        p=p->next;
        temp->next=p;
    }
    return head;
}