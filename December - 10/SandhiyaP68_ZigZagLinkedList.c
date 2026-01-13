#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* createNode(int val) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = val;
    newNode->next = NULL;
    return newNode;
}

struct Node* reverseList(struct Node* head) {
    struct Node* prev = NULL;
    struct Node* curr = head;
    struct Node* nextNode;

    while (curr != NULL) {
        nextNode = curr->next;
        curr->next = prev;
        prev = curr;
        curr = nextNode;
    }
    return prev;
}

int main() {
    int n, i, val;
    printf("Enter N: ");
    scanf("%d", &n);

    if (n <= 0) return 0;

    printf("Enter node values: ");

    struct Node *head = NULL, *temp = NULL, *curr = NULL;

    for (i = 0; i < n; i++) {
        scanf("%d", &val);
        temp = createNode(val);
        if (head == NULL) {
            head = temp;
            curr = temp;
        } else {
            curr->next = temp;
            curr = temp;
        }
    }

    // Step 1: Find middle
    struct Node *slow = head, *fast = head;
    while (fast->next != NULL && fast->next->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
    }

    // Step 2: Reverse second half
    struct Node* second = reverseList(slow->next);
    slow->next = NULL;

    // Step 3: Merge zig-zag
    struct Node* first = head;
    struct Node* next1;
    struct Node* next2;

    while (second != NULL) {
        next1 = first->next;
        next2 = second->next;

        first->next = second;
        second->next = next1;

        first = next1;
        second = next2;
    }

    // Print result
    curr = head;
    while (curr != NULL) {
        printf("%d ", curr->data);
        curr = curr->next;
    }

    return 0;
}
