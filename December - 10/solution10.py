#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

Node* createNode(int val) {
    Node* newNode = new Node();
    newNode->data = val;
    newNode->next = NULL;
    return newNode;
}

Node* reverse(Node* head) {
    Node* prev = NULL;
    Node* curr = head;

    while (curr) {
        Node* next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

void reorderList(Node* head) {
    if (!head || !head->next) return;

    Node* slow = head;
    Node* fast = head;

    while (fast->next && fast->next->next) {
        slow = slow->next;
        fast = fast->next->next;
    }

    Node* second = reverse(slow->next);
    slow->next = NULL;

    Node* first = head;

    while (second) {
        Node* t1 = first->next;
        Node* t2 = second->next;

        first->next = second;
        second->next = t1;

        first = t1;
        second = t2;
    }
}

void printList(Node* head) {
    while (head) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    int N;
    cin >> N;

    Node* head = NULL;
    Node* tail = NULL;

    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;
        Node* node = createNode(x);

        if (!head) {
            head = tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
    }

    reorderList(head);
    printList(head);

    return 0;
}

5
1 2 3 4 5
1 5 2 4 3 

