#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node* next;
};

struct node* createnode(int val) {
    struct node* n = (struct node*)malloc(sizeof(struct node));
    n->data = val;
    n->next = NULL;
    return n;
}

int main() {
    int n, i, val, pos;

    printf("enter number of nodes: ");
    scanf("%d", &n);

    struct node *head = NULL, *temp = NULL, *curr = NULL;

    printf("enter the node values: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &val);
        temp = createnode(val);

        if (head == NULL) {
            head = temp;
            curr = temp;
        } else {
            curr->next = temp;
            curr = temp;
        }
    }

    printf("enter n (from end): ");
    scanf("%d", &pos);

    struct node *fast = head, *slow = head;

    for (i = 0; i < pos; i++) {
        fast = fast->next;
    }

    if (fast == NULL) {
        struct node* del = head;
        head = head->next;
        free(del);
    } else {
        while (fast->next != NULL) {
            fast = fast->next;
            slow = slow->next;
        }

        struct node* del = slow->next;
        slow->next = slow->next->next;
        free(del);
    }

    curr = head;
    while (curr != NULL) {
        printf("%d ", curr->data);
        curr = curr->next;
    }

    return 0;
}
