#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int x) : data(x), next(nullptr) {}
};

Node* reverseList(Node* head) {
    Node* prev = nullptr;
    while (head) {
        Node* nextNode = head->next;
        head->next = prev;
        prev = head;
        head = nextNode;
    }
    return prev;
}

int main() {
    int N;
    cin >> N;
    if (N == 0) return 0;
    int x;
    cin >> x;
    Node* head = new Node(x);
    Node* tail = head;
    for (int i = 1; i < N; i++) {
        cin >> x;
        tail->next = new Node(x);
        tail = tail->next;
    }
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
        Node* t1 = first->next;
        Node* t2 = second->next;

        first->next = second;
        second->next = t1;

        first = t1;
        second = t2;
    }
    Node* curr = head;
    while (curr) {
        cout << curr->data << " ";
        curr = curr->next;
    }
    return 0;
}
