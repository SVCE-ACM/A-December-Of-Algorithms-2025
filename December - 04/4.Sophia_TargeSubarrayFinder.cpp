#include<stdio.h>
int main()
{
	int n, i, k;
	printf("Enter the size of the array: ");
	scanf("%d",&n);
	int A[n];
	printf("Enter the target sum: ");
	scanf("%d", &k);
	
	printf("Enter numbers: ");
	for(i=0; i<n; i++)
	{
		scanf("%d",&A[i]);
	}

	int start=0, sum=0;
	
	for(int end=0; end<n; end++)
	{
		sum+=A[end];
		
	while(sum>k && start<=end)
	{
		sum=sum-A[start];
		start++;
	}
	
	if(sum==k)
	{
		printf("%d %d", start, end);
		return 0;
	}	
	}
	printf("-1 -1");		
}
