#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left, *right;
};

struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->left = node->right = NULL;
    return node;
}

/* Build tree using level order, -1 means NULL */
struct Node* buildTree() {
    int x;
    scanf("%d", &x);
    if (x == -1) return NULL;

    struct Node* root = newNode(x);
    struct Node* queue[10000];
    int front = 0, rear = 0;

    queue[rear++] = root;

    while (front < rear) {
        struct Node* curr = queue[front++];

        scanf("%d", &x);
        if (x != -1) {
            curr->left = newNode(x);
            queue[rear++] = curr->left;
        }

        scanf("%d", &x);
        if (x != -1) {
            curr->right = newNode(x);
            queue[rear++] = curr->right;
        }
    }
    return root;
}

void markParents(struct Node* root, struct Node* parent[],
                 struct Node** targetNode, int target) {
    if (!root) return;

    if (root->data == target)
        *targetNode = root;

    if (root->left) {
        parent[root->left->data] = root;
        markParents(root->left, parent, targetNode, target);
    }
    if (root->right) {
        parent[root->right->data] = root;
        markParents(root->right, parent, targetNode, target);
    }
}

void burnTree(struct Node* target, struct Node* parent[]) {
    int visited[10000] = {0};
    struct Node* queue[10000];
    int front = 0, rear = 0;

    queue[rear++] = target;
    visited[target->data] = 1;

    while (front < rear) {
        int size = rear - front;

        for (int i = 0; i < size; i++) {
            struct Node* curr = queue[front++];
            printf("%d", curr->data);
            if (i != size - 1) printf(", ");

            if (curr->left && !visited[curr->left->data]) {
                visited[curr->left->data] = 1;
                queue[rear++] = curr->left;
            }
            if (curr->right && !visited[curr->right->data]) {
                visited[curr->right->data] = 1;
                queue[rear++] = curr->right;
            }
            if (parent[curr->data] && !visited[parent[curr->data]->data]) {
                visited[parent[curr->data]->data] = 1;
                queue[rear++] = parent[curr->data];
            }
        }
        printf("\n");
    }
}

int main() {
    struct Node* root = buildTree();

    int target;
    scanf("%d", &target);

    struct Node* parent[10000] = {NULL};
    struct Node* targetNode = NULL;

    markParents(root, parent, &targetNode, target);

    if (targetNode)
        burnTree(targetNode, parent);

    return 0;
}
