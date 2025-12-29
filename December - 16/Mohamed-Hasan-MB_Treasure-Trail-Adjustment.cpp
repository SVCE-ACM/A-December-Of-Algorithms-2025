#include <bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* fast = dummy;
        ListNode* slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast->next;
        }
        while (fast->next != NULL) {
            fast = fast->next;
            slow = slow->next;
        }
        slow->next = slow->next->next;
        return dummy->next;
    }
};

int main() {
    int n;
    int size;
    cin >> size;
    if (size == 0) {
        cout << "[]";
        return 0;
    }
    vector<int> values(size);
    for (int i = 0; i < size; i++) {
        cin >> values[i];
    }
    cin >> n;
    ListNode* head = new ListNode(values[0]);
    ListNode* curr = head;
    for (int i = 1; i < size; i++) {
        curr->next = new ListNode(values[i]);
        curr = curr->next;
    }
    Solution sol;
    head = sol.removeNthFromEnd(head, n);
    if (!head) {
        cout << "[]";
        return 0;
    }
    curr = head;
    while (curr) {
        cout << curr->val;
        if (curr->next) cout << " ";
        curr = curr->next;
    }
    return 0;
}
