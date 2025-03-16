/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* modifiedList(int* nums, int numsSize, struct ListNode* head) {
  int i;
  int largest=nums[0];


  for(i=0;i<numsSize;i++)
  {
    if(nums[i]>largest)largest=nums[i];
  }  


  int hash[largest+1];
  for(i=0;i<=largest;i++)
  {
    hash[i]=0;
  }


  for(i=0;i<numsSize;i++)
  {
    hash[nums[i]]+=1;
  }


  struct ListNode *p=head;
  struct ListNode *prev=NULL;
      while (p != NULL) {
        if (p->val <= largest && hash[p->val] != 0) {
            struct ListNode *temp = p;
            p = p->next;
            if (prev == NULL) {
                head = p; 
            } else {
                prev->next = p;
            }
            free(temp);
        } else {
            prev = p;
            p = p->next;
        }
    }

  return head;
}