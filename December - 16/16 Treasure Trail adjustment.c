#include <stdio.h>
#include <stdlib.h>

// Definition for singly-linked list
struct ListNode {
    int val;
    struct ListNode *next;
};

// Create a new node
struct ListNode* newNode(int val) {
    struct ListNode* node = (struct ListNode*)malloc(sizeof(struct ListNode));
    node->val = val;
    node->next = NULL;
    return node;
}

// Remove nth node from end
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode* dummy = newNode(0);
    dummy->next = head;
    struct ListNode* first = dummy;
    struct ListNode* second = dummy;

    // Move first n+1 steps ahead
    for(int i = 0; i <= n; i++) {
        first = first->next;
    }

    // Move both pointers
    while(first) {
        first = first->next;
        second = second->next;
    }

    // Remove node
    struct ListNode* temp = second->next;
    second->next = second->next->next;
    free(temp);

    struct ListNode* newHead = dummy->next;
    free(dummy);
    return newHead;
}

// Print linked list
void printList(struct ListNode* head) {
    struct ListNode* temp = head;
    while(temp) {
        printf("%d ", temp->val);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    int sz, n, val;
    printf("Enter number of markers: ");
    scanf("%d", &sz);

    printf("Enter marker values:\n");
    struct ListNode* head = NULL;
    struct ListNode* tail = NULL;
    for(int i = 0; i < sz; i++) {
        scanf("%d", &val);
        struct ListNode* node = newNode(val);
        if(!head) {
            head = tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
    }

    printf("Enter n (marker from end to remove): ");
    scanf("%d", &n);

    head = removeNthFromEnd(head, n);

    printf("Updated trail:\n");
    printList(head);

    return 0;
}
