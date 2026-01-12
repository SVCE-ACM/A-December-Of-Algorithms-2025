#include<stdio.h>
void Binary(int n)
{
	int bin[32];
    int i = 0;

    if (n == 0) 
	{
        printf("0");
        return;
    }

    while (n > 0) 
	{
        bin[i] = n % 2;
        n = n / 2;
        i++;
    }

    for (int j = i - 1; j >= 0; j--) 
	{
        printf("%d", bin[j]);
    }
	
}
int main()
{
	int num, i;
	printf("Enter a number: ");
	scanf("%d",&num);
	
	for(i=1; i<=num ; i++)
	{
		printf("%d\t %o\t %x\t",i,i,i);
		Binary(i);
		printf("\n");
	}
}
