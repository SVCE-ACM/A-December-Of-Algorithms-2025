#include <iostream>
#include <vector>
using namespace std;

struct Node {
    int val;
    Node* next;
    Node(int v) : val(v), next(nullptr) {}
};

void printList(Node* head) {
    Node* curr = head;
    while (curr) {
        cout << curr->val << " ";
        curr = curr->next;
    }
    cout << endl;
}

Node* reverseList(Node* head) {
    Node* prev = nullptr;
    Node* curr = head;
    while (curr) {
        Node* nextNode = curr->next;
        curr->next = prev;
        prev = curr;
        curr = nextNode;
    }
    return prev;
}

int main() {
    int N;
    cin >> N;
    if (N == 0) return 0; 

    Node* head = nullptr;
    Node* tail = nullptr;

    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;
        Node* node = new Node(x);
        if (!head) head = tail = node;
        else {
            tail->next = node;
            tail = node;
        }
    }

    if (N == 1) { printList(head); return 0; }

    Node* slow = head;
    Node* fast = head;
    while (fast->next && fast->next->next) {
        slow = slow->next;
        fast = fast->next->next;
    }

    Node* second = reverseList(slow->next);
    slow->next = nullptr; 

    Node* first = head;
    while (second) {
        Node* tmp1 = first->next;
        Node* tmp2 = second->next;

        first->next = second;
        second->next = tmp1;

        first = tmp1;
        second = tmp2;
    }

    printList(head);

    return 0;
}
