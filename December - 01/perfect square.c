#include<stdio.h>
#include<math.h>
int main()
{
    int n,a=0,i,j;
    printf("Enter a number:");
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
    for(j=1;j<=i;j++)
    {
        if(sqrt(i)==j)
        {
        printf(" %d",i);
        a++;
        }
    }
    }
printf("\n%d",a);
}
