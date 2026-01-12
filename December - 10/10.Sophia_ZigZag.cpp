#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node* next;
};

Node* reverse(Node* head)
{
    Node* prev = NULL;
    Node* curr = head;

    while (curr != NULL)
    {
        Node* nextNode = curr->next;
        curr->next = prev;
        prev = curr;
        curr = nextNode;
    }
    return prev;
}

void reorderList(Node* head)
{
    if (!head || !head->next)
        return;

    Node* slow = head;
    Node* fast = head;

    while (fast->next && fast->next->next)
    {
        slow = slow->next;
        fast = fast->next->next;
    }

    Node* second = reverse(slow->next);
    slow->next = NULL;   
    Node* first = head;

    while (second)
    {
        Node* temp1 = first->next;
        Node* temp2 = second->next;

        first->next = second;
        second->next = temp1;

        first = temp1;
        second = temp2;
    }
}

Node* createNode(int val)
{
    Node* newNode = new Node();
    newNode->data = val;
    newNode->next = NULL;
    return newNode;
}

void printList(Node* head)
{
    while (head)
    {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

int main()
{
    int n;
    cout<<"Enter the  no. of elements: ";
    cin >> n;

    Node* head = NULL;
    Node* tail = NULL;
    
	cout<<"Enter the numbers: ";
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        Node* newNode = createNode(x);

        if (!head)
            head = tail = newNode;
        else
        {
            tail->next = newNode;
            tail = newNode;
        }
    }

    reorderList(head);
    printList(head);

    return 0;
}

