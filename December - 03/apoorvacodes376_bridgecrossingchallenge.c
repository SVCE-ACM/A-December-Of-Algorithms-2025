#include<stdio.h>
#include<stdlib.h>

struct bridge
{
    int n;
    int *arr;
    int sum;
    // struct bridge *next;
    int next;
};

void initialize(struct bridge *b)
{
    b->n=0;
    b->sum=0;
    b->next=0;
}

void getinput(struct bridge *b)
{
    printf("enter a number:");
    scanf("%d",&b->n);
    printf("enter array:");
    for(int i=0;i<b->n;i++)
    {
        scanf("%d",&b->arr[i]);
    }
}

void findnext(struct bridge *b)
{
    for(int i=0;i<b->n;i++)
    {
        b->next=b->arr[i+1];
        if((b->next!=0)&&(i<b->n-2))
        {
            b->sum+=b->arr[i];
        }
        // else if(b->next==0)
        else
        {
            // sum-=arr[i];
            for(int j=b->arr[i];j<b->n;j++)
            {
                b->sum+=b->arr[j];
            }
        }
    }
    printf("sum: %d",b->sum);
}

int main()
{
    struct bridge *b=NULL;
    b=malloc(sizeof(struct bridge));
    initialize(b);
    getinput(b);
    findnext(b);
    return 0;
}