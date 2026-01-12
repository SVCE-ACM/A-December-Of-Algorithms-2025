#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct ListNode {
    int val;
    struct ListNode* next;
} ListNode;
ListNode* buildList(char** nodes, int n) {
    if (n == 0) return NULL;
    ListNode* head = (ListNode*)malloc(sizeof(ListNode));
    head->val = atoi(nodes[0]);
    head->next = NULL;
    ListNode* curr = head;
    for (int i = 1; i < n; i++) {
        ListNode* node = (ListNode*)malloc(sizeof(ListNode));
        node->val = atoi(nodes[i]);
        node->next = NULL;
        curr->next = node;
        curr = node;
    }
    return head;
}
ListNode* removeNthFromEnd(ListNode* head, int n) {
    ListNode* dummy = (ListNode*)malloc(sizeof(ListNode));
    dummy->next = head;
    ListNode* fast = dummy;
    ListNode* slow = dummy;
    for (int i = 0; i <= n; i++) fast = fast->next;
    while (fast) {
        fast = fast->next;
        slow = slow->next;
    }
    ListNode* temp = slow->next;
    slow->next = slow->next->next;
    free(temp);

    ListNode* newHead = dummy->next;
    free(dummy);
    return newHead;
}
void printList(ListNode* head) {
    printf("[");
    while (head) {
        printf("%d", head->val);
        if (head->next) printf(",");
        head = head->next;
    }
    printf("]\n");
}
int main() {
    char input[200];
    int n;
    printf("Enter linked list: ");
    scanf("%s", input);
    printf("Enter n: ");
    scanf("%d", &n);
    int len = strlen(input);
    input[len-1] = '\0';
    memmove(input, input+1, len-1);
    char* nodes[100];
    int count = 0;
    char* token = strtok(input, ",");
    while (token) {
        nodes[count++] = token;
        token = strtok(NULL, ",");
    }
    ListNode* head = buildList(nodes, count);
    head = removeNthFromEnd(head, n);
    printList(head);
    return 0;
}
