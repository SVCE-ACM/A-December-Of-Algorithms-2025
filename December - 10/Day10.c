#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node* createNode(int value) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = value;
    node->next = NULL;
    return node;
}

struct Node* reverseList(struct Node* head) {
    struct Node *prev = NULL, *current = head, *nextNode;

    while (current) {
        nextNode = current->next;
        current->next = prev;
        prev = current;
        current = nextNode;
    }
    return prev;
}

void reorderList(struct Node* head) {
    if (!head || !head->next)
        return;

    struct Node *slow = head, *fast = head;

    while (fast->next && fast->next->next) {
        slow = slow->next;
        fast = fast->next->next;
    }

    struct Node* secondHalf = reverseList(slow->next);
    slow->next = NULL;

    struct Node* firstHalf = head;

    while (secondHalf) {
        struct Node* temp1 = firstHalf->next;
        struct Node* temp2 = secondHalf->next;

        firstHalf->next = secondHalf;
        secondHalf->next = temp1;

        firstHalf = temp1;
        secondHalf = temp2;
    }
}

void printList(struct Node* head) {
    while (head) {
        printf("%d ", head->data);
        head = head->next;
    }
}

int main() {
    int N;
    scanf("%d", &N);

    struct Node *head = NULL, *tail = NULL;

    for (int i = 0; i < N; i++) {
        int value;
        scanf("%d", &value);
        struct Node* node = createNode(value);

        if (!head)
            head = tail = node;
        else {
            tail->next = node;
            tail = node;
        }
    }

    reorderList(head);
    printList(head);

    return 0;
}
