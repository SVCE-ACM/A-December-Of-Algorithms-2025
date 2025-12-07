#include<stdio.h>
#include<stdlib.h>

struct perfect{
    int n;
    // struct perfect *arr[];
    // int *arr;
    int c;
};

int initialize(struct perfect *p)
{
    p->n=0;
    p->c=0;
}

void getinput(struct perfect *p)
{
    // int arr[p->n];
    printf("enter number:");
    scanf("%d",&p->n);
    // printf("Array: \n");
    // for(int i=1;i<p->n;i++)
    // {
    //     printf("%d ",i);
    //     // p->arr[i]=i;
    // }
    // printf("\n");
}

void square(struct perfect *p)
{
    // int s=p->n;
    for(int i=1;i*i<=p->n;i++)
    {
        // int temp=i*i;
        // if(temp<=p->n)
        // {
            // printf("%d ",temp);
            printf("%d ",i*i);
            p->c++;
        // }
    }
    printf("\n%d",p->c);

}

int main()
{
    struct perfect *p;
    initialize(p);
    getinput(p);
    square(p);
    return 0;
}