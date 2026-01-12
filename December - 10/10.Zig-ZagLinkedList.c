#include <stdio.h>
#include <stdlib.h>
struct Node {
    int data;
    struct Node* next;
};
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*) malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}
struct Node* reverseList(struct Node* head) {
    struct Node* prev = NULL;
    struct Node* curr = head;
    struct Node* next;
    while (curr) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
void zigZagList(struct Node** headRef) {
    if (!*headRef || !(*headRef)->next) return;
    struct Node* slow = *headRef;
    struct Node* fast = *headRef;
    while (fast->next && fast->next->next) {
        slow = slow->next;
        fast = fast->next->next;
    }
    struct Node* second = reverseList(slow->next);
    slow->next = NULL;
    struct Node* first = *headRef;
    struct Node* temp1;
    struct Node* temp2;
    while (second) {
        temp1 = first->next;
        temp2 = second->next;
        first->next = second;
        second->next = temp1;
        first = temp1;
        second = temp2;
    }
}
void printList(struct Node* head) {
    struct Node* curr = head;
    while (curr) {
        printf("%d ", curr->data);
        curr = curr->next;
    }
    printf("\n");
}
int main() {
    int N;
    printf("Enter N: ");
    scanf("%d", &N);
    if (N <= 0) return 0;
    printf("Enter node values: ");
    int val;
    struct Node* head = NULL;
    struct Node* tail = NULL;
    for (int i = 0; i < N; i++) {
        scanf("%d", &val);
        struct Node* newNode = createNode(val);
        if (!head) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }
    zigZagList(&head);
    printList(head);
    struct Node* temp;
    while (head) {
        temp = head;
        head = head->next;
        free(temp);
    }
    return 0;
}
