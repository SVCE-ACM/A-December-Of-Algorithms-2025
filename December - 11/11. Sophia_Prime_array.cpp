#include<stdio.h>
int main()
{
	int num,n;
	int count=0;
	printf("Enter a number: ");
	scanf("%d", &num);
	
	for(int n=2; n<num; n++)
	{
		int flag=0;
		for(int j=1; j<=n; j++)
	{
		if(n%j==0)
		flag++;
	}
	if (flag==2)
		count++;	
	}	
	
	printf("The no.of prime numbers in the range is %d", count);
}
