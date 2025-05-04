/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* nextLargerNodes(struct ListNode* head, int* returnSize) {
    int capacity = 10000; // assume max size or dynamically resize if needed
    int* res = (int*)malloc(sizeof(int) * capacity);
    int n = 0;

    struct ListNode* current = head;
    while (current) {
        res[n++] = current->val;
        current = current->next;
    }

    *returnSize = n;

    int* stack = (int*)malloc(sizeof(int) * n);
    int top = -1;

    for (int i = n - 1; i >= 0; i--) {
        int val = res[i];

        while (top >= 0 && stack[top] <= val) {
            top--;
        }

        if (top == -1) {
            res[i] = 0;
        } else {
            res[i] = stack[top];
        }

        top++;
        stack[top] = val;
    }

    free(stack);
    return res;
}