#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int x) : data(x), left(NULL), right(NULL) {}
};
Node* markParents(Node* root, unordered_map<Node*, Node*>& parent, int target) {
    queue<Node*> q;
    q.push(root);
    Node* targetNode = NULL;
    while (!q.empty()) {
        Node* curr = q.front();
        q.pop();

        if (curr->data == target)
            targetNode = curr;

        if (curr->left) {
            parent[curr->left] = curr;
            q.push(curr->left);
        }
        if (curr->right) {
            parent[curr->right] = curr;
            q.push(curr->right);
        }
    }
    return targetNode;
}
void burnTree(Node* root, int target) {
    unordered_map<Node*, Node*> parent;
    Node* targetNode = markParents(root, parent, target);
    if (!targetNode) return;
    unordered_map<Node*, bool> visited;
    queue<Node*> q;
    q.push(targetNode);
    visited[targetNode] = true;
    while (!q.empty()) {
        int sz = q.size();
        vector<int> level;
        for (int i = 0; i < sz; i++) {
            Node* curr = q.front();
            q.pop();
            level.push_back(curr->data);
            if (curr->left && !visited[curr->left]) {
                visited[curr->left] = true;
                q.push(curr->left);
            }
            if (curr->right && !visited[curr->right]) {
                visited[curr->right] = true;
                q.push(curr->right);
            }
            if (parent[curr] && !visited[parent[curr]]) {
                visited[parent[curr]] = true;
                q.push(parent[curr]);
            }
        }
        for (int i = 0; i < level.size(); i++) {
            cout << level[i];
            if (i + 1 < level.size()) cout << ", ";
        }
        cout << "\n";
    }
}
