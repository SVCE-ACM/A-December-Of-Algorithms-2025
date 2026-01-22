#include <stdio.h>
#include <stdlib.h>

// Define node structure
struct Node {
    int data;
    struct Node* next;
};

// Function to create a new node
struct Node* newNode(int val) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = val;
    node->next = NULL;
    return node;
}

// Function to reverse a linked list
struct Node* reverse(struct Node* head) {
    struct Node* prev = NULL;
    struct Node* curr = head;
    struct Node* next;
    while(curr) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

// Function to print the linked list
void printList(struct Node* head) {
    struct Node* temp = head;
    while(temp) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

// Function to reorder the list
struct Node* reorderList(struct Node* head) {
    if(!head || !head->next) return head;

    // Step 1: Find middle
    struct Node* slow = head;
    struct Node* fast = head;
    while(fast->next && fast->next->next) {
        slow = slow->next;
        fast = fast->next->next;
    }

    // Step 2: Reverse second half
    struct Node* second = reverse(slow->next);
    slow->next = NULL; // break first half

    // Step 3: Merge two halves
    struct Node* first = head;
    struct Node* temp1;
    struct Node* temp2;
    while(second) {
        temp1 = first->next;
        temp2 = second->next;

        first->next = second;
        second->next = temp1;

        first = temp1;
        second = temp2;
    }

    return head;
}

int main() {
    int n;
    printf("Enter N: ");
    scanf("%d", &n);

    printf("Enter node values: ");
    int val;
    struct Node* head = NULL;
    struct Node* tail = NULL;
    for(int i=0; i<n; i++) {
        scanf("%d", &val);
        struct Node* node = newNode(val);
        if(!head) {
            head = node;
            tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
    }

    head = reorderList(head);

    printList(head);

    return 0;
}
