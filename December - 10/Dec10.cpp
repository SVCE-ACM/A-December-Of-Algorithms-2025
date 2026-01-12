#include <iostream>
using namespace std;
struct Node
{
    int val;
    Node* next;
    Node(int x){val=x; next=nullptr;}
};
Node* reverse(Node* head)
{
    Node *prev=nullptr,*curr=head,*next=nullptr;
    while(curr)
    {
        next=curr->next;
        curr->next=prev;
        prev=curr;
        curr=next;
    }
    return prev;
}

int main()
{
    int n;
    cin >> n;
    int x;
    cin >> x;
    Node* head=new Node(x);
    Node* tail=head;
    for(int i=1;i<n;i++)
    {
        cin >> x;
        tail->next=new Node(x);
        tail=tail->next;
    }
    if(n<2){cout<<head->val; return 0;}

    Node *slow=head,*fast=head;
    while(fast->next && fast->next->next)
    {
        slow=slow->next;
        fast=fast->next->next;
    }

    Node* second=reverse(slow->next);
    slow->next=nullptr;
    Node* first=head;

    while(second)
    {
        Node* tmp1=first->next;
        Node* tmp2=second->next;
        first->next=second;
        second->next=tmp1;
        first=tmp1;
        second=tmp2;
    }

    Node* curr=head;
    while(curr)
    {
        cout<<curr->val<<" ";
        curr=curr->next;
    }
    return 0;
}
