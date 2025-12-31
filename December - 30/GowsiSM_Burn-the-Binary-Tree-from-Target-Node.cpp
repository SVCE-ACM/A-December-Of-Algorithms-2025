#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <unordered_set>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void mapParents(TreeNode* root, unordered_map<TreeNode*, TreeNode*>& parent) {
    queue<TreeNode*> q;
    q.push(root);

    while (!q.empty()) {
        TreeNode* curr = q.front();
        q.pop();

        if (curr->left) {
            parent[curr->left] = curr;
            q.push(curr->left);
        }
        if (curr->right) {
            parent[curr->right] = curr;
            q.push(curr->right);
        }
    }
}

TreeNode* findTarget(TreeNode* root, int target) {
    if (!root) return NULL;
    if (root->val == target) return root;

    TreeNode* left = findTarget(root->left, target);
    if (left) return left;

    return findTarget(root->right, target);
}

void burnTree(TreeNode* root, int target) {
    unordered_map<TreeNode*, TreeNode*> parent;
    mapParents(root, parent);

    TreeNode* start = findTarget(root, target);
    if (!start) return;

    queue<TreeNode*> q;
    unordered_set<TreeNode*> visited;

    q.push(start);
    visited.insert(start);

    while (!q.empty()) {
        int size = q.size();

        for (int i = 0; i < size; i++) {
            TreeNode* curr = q.front();
            q.pop();

            cout << curr->val;
            if (i < size - 1) cout << ", ";

            if (curr->left && !visited.count(curr->left)) {
                visited.insert(curr->left);
                q.push(curr->left);
            }
            if (curr->right && !visited.count(curr->right)) {
                visited.insert(curr->right);
                q.push(curr->right);
            }
            if (parent[curr] && !visited.count(parent[curr])) {
                visited.insert(parent[curr]);
                q.push(parent[curr]);
            }
        }
        cout << endl;
    }
}
