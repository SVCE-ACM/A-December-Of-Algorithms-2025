#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* parents[10001];
int visited[10001];

struct TreeNode* findTarget(struct TreeNode* root, int target) {
    if (!root) return NULL;
    if (root->val == target) return root;
    struct TreeNode* left = findTarget(root->left, target);
    if (left) return left;
    return findTarget(root->right, target);
}

void buildParent(struct TreeNode* root) {
    if (!root) return;
    if (root->left) {
        parents[root->left->val] = root;
        buildParent(root->left);
    }
    if (root->right) {
        parents[root->right->val] = root;
        buildParent(root->right);
    }
}

int main() {
    struct TreeNode *root = NULL;
    int target;
    scanf("%d", &target);

    buildParent(root);
    struct TreeNode* start = findTarget(root, target);

    struct TreeNode* queue[10001];
    int front = 0, rear = 0;

    queue[rear++] = start;
    visited[start->val] = 1;

    while (front < rear) {
        int size = rear - front;
        for (int i = 0; i < size; i++) {
            struct TreeNode* cur = queue[front++];
            printf("%d ", cur->val);

            if (cur->left && !visited[cur->left->val]) {
                visited[cur->left->val] = 1;
                queue[rear++] = cur->left;
            }
            if (cur->right && !visited[cur->right->val]) {
                visited[cur->right->val] = 1;
                queue[rear++] = cur->right;
            }
            if (parents[cur->val] && !visited[parents[cur->val]->val]) {
                visited[parents[cur->val]->val] = 1;
                queue[rear++] = parents[cur->val];
            }
        }
        printf("\n");
    }
    return 0;
}
