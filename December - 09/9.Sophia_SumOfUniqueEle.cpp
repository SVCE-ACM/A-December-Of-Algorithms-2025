#include<stdio.h>
int main()
{
	int n, sum=0;
	printf("Enter the no. of elements: ");
	scanf("%d",&n);
	int array[n];
	
	printf("Enter the elements:\n ");
	for (int i=0; i<n; i++)
	{
		scanf("%d",&array[i]);
	}
	
	for(int x=0; x<n; x++)
	{
		int count=0;
		for(int y=0; y<n; y++)
		{
			if(array[x]==array[y])	
			{
				count++;
			}
		}
		
		if(count==1)
		{
			sum+=array[x];
		}
	}
	
	printf("Sum is %d",sum);
	return 0;
}
