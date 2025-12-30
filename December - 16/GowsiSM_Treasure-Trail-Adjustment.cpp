#include <iostream>
#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* removeNthFromEnd(ListNode* head, int n) {
    ListNode* dummy = new ListNode(0);
    dummy->next = head;
    ListNode* fast = dummy;
    ListNode* slow = dummy;

    for (int i = 0; i < n; i++) fast = fast->next;

    while (fast->next != NULL) {
        fast = fast->next;
        slow = slow->next;
    }

    slow->next = slow->next->next;
    return dummy->next;
}

ListNode* createList(vector<int>& arr) {
    if (arr.empty()) return NULL;

    ListNode* head = new ListNode(arr[0]);
    ListNode* current = head;

    for (int i = 1; i < arr.size(); i++) {
        current->next = new ListNode(arr[i]);
        current = current->next;
    }
    return head;
}

void printList(ListNode* head) {
    while (head != NULL) {
        cout << head->val << " ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    vector<int> values = {1, 2, 3, 4, 5};
    int n = 2;

    ListNode* head = createList(values);

    cout << "Original List: ";
    printList(head);

    head = removeNthFromEnd(head, n);
    cout << "After Removing " << n << "th node from end: ";
    printList(head);

}
