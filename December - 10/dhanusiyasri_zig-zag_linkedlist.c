#include<stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node *next, *prev;
};
void printzigzag(struct node *head,struct node *end,int n){
    struct node *temp1=head->next;
    struct node *temp2=end->prev;
    int mid=n/2;
    for(int i=0;i<mid;i++){
        printf("%d ",temp1->data);
        temp1=temp1->next;
        printf("%d ",temp2->data);
        temp2=temp2->prev;
    }
    if(n%2!=0){
        printf("%d ",temp1->data);
    }
    
}
void main()
{
    struct node *head=NULL;
    struct node *end=NULL;
    head=(struct node*)malloc(sizeof(struct node));
    end=(struct node*)malloc(sizeof(struct node));
    head->next=end;
    head->prev=NULL;
    end->next=NULL;
    end->prev=head;
    int n,e;
    struct node *temp,*curr=head;
    printf("Enter N: ");
    scanf("%d",&n);
    printf("Enter node values: ");
    for(int i=0;i<n;i++){
        temp=malloc(sizeof(struct node));
        scanf("%d",&e);
        temp->data=e;
        curr->next=temp;
        temp->prev=curr;
        end->prev=temp;
        temp->next=end;
        curr=temp;
    }
    printzigzag(head,end,n);
}