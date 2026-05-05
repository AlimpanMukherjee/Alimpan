/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    int i=0,j=0,n=1;
    if(head==NULL)
    {
        return NULL;
    }
    //struct node *p=(struct node*)malloc*(sizeof(struct node));
    struct ListNode *p=head;
    while(p->next!=NULL)
    {
        n++;
        p=p->next;
    }
    k=k%n;
    p=head;
    for(i=0;i<n-k-1;i++)
    {
        p=p->next;
    }
    struct ListNode *temp=p;
    while(p->next!=NULL)
    {
        p=p->next;
    }
    p->next=head;
    head=temp->next;
    p=head;
    temp->next=NULL;
    while(p!=NULL)
    {
        printf("%d ",p->val);
        p=p->next;
    }
    return head;
}