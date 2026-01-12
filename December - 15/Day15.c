#include <stdlib.h>
#include <stdbool.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

bool isCompleteTree(struct TreeNode* root) {
    if (!root) return true;
    struct TreeNode* queue[1001];
    int front = 0, rear = 0;
    bool seenNull = false;
    queue[rear++] = root;
    while (front < rear) {
        struct TreeNode* node = queue[front++];
        if (!node) {
            seenNull = true;
        } else {
            if (seenNull) return false;
            queue[rear++] = node->left;
            queue[rear++] = node->right;
        }
    }
    return true;
}
