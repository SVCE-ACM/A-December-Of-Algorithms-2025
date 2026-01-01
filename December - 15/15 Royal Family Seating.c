#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Tree node
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

// Queue node for BFS
struct QueueNode {
    struct TreeNode* node;
    struct QueueNode* next;
};

struct Queue {
    struct QueueNode* front;
    struct QueueNode* rear;
};

void enqueue(struct Queue* q, struct TreeNode* node) {
    struct QueueNode* newNode = (struct QueueNode*)malloc(sizeof(struct QueueNode));
    newNode->node = node;
    newNode->next = NULL;
    if(!q->rear) {
        q->front = q->rear = newNode;
    } else {
        q->rear->next = newNode;
        q->rear = newNode;
    }
}

struct TreeNode* dequeue(struct Queue* q) {
    if(!q->front) return NULL;
    struct QueueNode* temp = q->front;
    struct TreeNode* node = temp->node;
    q->front = q->front->next;
    if(!q->front) q->rear = NULL;
    free(temp);
    return node;
}

bool isEmpty(struct Queue* q) {
    return q->front == NULL;
}

// Create a new tree node
struct TreeNode* newNode(int val) {
    if(val == -1) return NULL; // -1 represents NULL
    struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = val;
    node->left = node->right = NULL;
    return node;
}

// Check if tree is complete
bool isCompleteBinaryTree(struct TreeNode* root) {
    if(!root) return true;
    struct Queue q = {NULL, NULL};
    enqueue(&q, root);
    bool end = false;

    while(!isEmpty(&q)) {
        struct TreeNode* node = dequeue(&q);
        if(!node) {
            end = true;
        } else {
            if(end) return false; // non-NULL after NULL → not complete
            enqueue(&q, node->left);
            enqueue(&q, node->right);
        }
    }
    return true;
}

int main() {
    int n;
    printf("Enter number of nodes in level-order: ");
    scanf("%d", &n);

    if(n == 0) {
        printf("true\n");
        return 0;
    }

    printf("Enter node values (-1 for NULL) in level-order:\n");
    int val;
    scanf("%d", &val);
    struct TreeNode* root = newNode(val);

    struct Queue q = {NULL, NULL};
    enqueue(&q, root);

    int count = 1;
    while(count < n) {
        struct TreeNode* current = dequeue(&q);
        if(!current) continue;

        // Left child
        if(count < n) {
            scanf("%d", &val);
            current->left = newNode(val);
            enqueue(&q, current->left);
            count++;
        }
        // Right child
        if(count < n) {
            scanf("%d", &val);
            current->right = newNode(val);
            enqueue(&q, current->right);
            count++;
        }
    }

    if(isCompleteBinaryTree(root))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}
