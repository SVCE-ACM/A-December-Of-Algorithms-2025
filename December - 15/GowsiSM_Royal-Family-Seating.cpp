#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool isCompleteBinaryTree(TreeNode* root) {
    if (!root) return true;

    queue<TreeNode*> q;
    q.push(root);

    bool foundNull = false;

    while (!q.empty()) {
        TreeNode* curr = q.front();
        q.pop();

        if (curr == NULL) {
            foundNull = true;
        } else {
            if (foundNull) return false; 
            q.push(curr->left);
            q.push(curr->right);
        }
    }
    return true;
}

TreeNode* buildTree(vector<int>& arr) {
    if (arr.empty() || arr[0] == -1) return NULL;

    vector<TreeNode*> nodes(arr.size(), NULL);

    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] != -1)
            nodes[i] = new TreeNode(arr[i]);
    }

    for (int i = 0; i < arr.size(); i++) {
        if (nodes[i]) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.size())
                nodes[i]->left = nodes[left];
            if (right < arr.size())
                nodes[i]->right = nodes[right];
        }
    }
    return nodes[0];
}

int main() {
    int N;
    cout << "Enter number of nodes: ";
    cin >> N;

    vector<int> arr(N);
    cout << "Enter nodes (use -1 for null): ";
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    TreeNode* root = buildTree(arr);

    if (isCompleteBinaryTree(root))
        cout << "true" << endl;
    else
        cout << "false" << endl;

}
