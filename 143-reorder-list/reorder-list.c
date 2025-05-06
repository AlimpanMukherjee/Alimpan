/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void reorderList(struct ListNode* head) {
    struct ListNode *p=head;
    int n=0;
    while(p!=NULL)
    {
        n++;
        p=p->next;
    }
    int dummyArray[n];
    int finalArray[n];
    p=head;
    int i=0;
    while(p!=NULL)
    {
        dummyArray[i]=p->val;
        i++;
        p=p->next;
    }
    int j=0;
    for(int i=0;i<n/2;i++)
    {
        finalArray[j]=dummyArray[i];
        finalArray[j+1]=dummyArray[n-1-i];
        j+=2;
    }
    if(n%2==1)
    {
        finalArray[n-1]=dummyArray[n/2];
    }
    p=head;
    i=0;
    while(p!=NULL)
    {
        p->val=finalArray[i];
        i++;
        p=p->next;
    }
    //return head;
}