#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
} TreeNode;
typedef struct QueueNode {
    TreeNode* treeNode;
    struct QueueNode* next;
} QueueNode;
typedef struct Queue {
    QueueNode *front, *rear;
} Queue;
void enqueue(Queue* q, TreeNode* node) {
    QueueNode* temp = (QueueNode*)malloc(sizeof(QueueNode));
    temp->treeNode = node;
    temp->next = NULL;
    if (!q->rear) { q->front = q->rear = temp; return; }
    q->rear->next = temp;
    q->rear = temp;
}
TreeNode* dequeue(Queue* q) {
    if (!q->front) return NULL;
    QueueNode* temp = q->front;
    TreeNode* node = temp->treeNode;
    q->front = q->front->next;
    if (!q->front) q->rear = NULL;
    free(temp);
    return node;}
int isEmpty(Queue* q) { return q->front == NULL; }
TreeNode* buildTree(char** nodes, int n) {
    if (n == 0 || strcmp(nodes[0], "null") == 0) return NULL;
    TreeNode* root = (TreeNode*)malloc(sizeof(TreeNode));
    root->val = atoi(nodes[0]);
    root->left = root->right = NULL;
    Queue q = {NULL, NULL};
    enqueue(&q, root);
    int i = 1;
    while (!isEmpty(&q) && i < n) {
        TreeNode* curr = dequeue(&q);
        if (i < n && strcmp(nodes[i], "null") != 0) {
            TreeNode* left = (TreeNode*)malloc(sizeof(TreeNode));
            left->val = atoi(nodes[i]);
            left->left = left->right = NULL;
            curr->left = left;
            enqueue(&q, left);
        }
        i++;
        if (i < n && strcmp(nodes[i], "null") != 0) {
            TreeNode* right = (TreeNode*)malloc(sizeof(TreeNode));
            right->val = atoi(nodes[i]);
            right->left = right->right = NULL;
            curr->right = right;
            enqueue(&q, right);
        }
        i++;
    }
    return root;
}
int isCompleteTree(TreeNode* root) {
    if (!root) return 1;
    Queue q = {NULL, NULL};
    enqueue(&q, root);
    int seenNull = 0;

    while (!isEmpty(&q)) {
        TreeNode* curr = dequeue(&q);
        if (!curr) seenNull = 1;
        else {
            if (seenNull) return 0;
            enqueue(&q, curr->left);
            enqueue(&q, curr->right);
        }
    }
    return 1;
}
int main() {
    char input[1000];
    printf("Enter tree: ");
    scanf("%s", input);
    int len = strlen(input);
    input[len-1] = '\0';
    memmove(input, input+1, len-1);
    char* nodes[1000];
    int count = 0;
    char* token = strtok(input, ",");
    while (token != NULL) {
        nodes[count++] = token;
        token = strtok(NULL, ",");
    }
    TreeNode* root = buildTree(nodes, count);
    if (isCompleteTree(root)) printf("true\n");
    else printf("false\n");
    return 0;
}
