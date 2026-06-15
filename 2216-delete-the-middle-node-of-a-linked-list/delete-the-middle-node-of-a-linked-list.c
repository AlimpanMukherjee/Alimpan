/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteMiddle(struct ListNode* head) {
    int n=0,mid;
    struct ListNode *p=head;
    struct ListNode *temp=NULL;
    if(head->next==NULL)
    {
        return NULL;
    }
    while(p->next!=NULL)
    {
        n++;
        p=p->next;
    }
    if(n%2==0)
    {
        mid=n/2;
    }
    else
    {
        mid=n/2+1;
    }
    p=head;
    for(int i=0;i<mid;i++)
    {
        temp=p;
        p=p->next;
    }
    temp->next=p->next;
    free(p);
    return head;

}