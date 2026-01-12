#include<stdio.h>
int main()
{
	int n,x,y;
	int duplicate;
	printf("Enter the no. of elements: ");
	scanf("%d",&n);
	int array[n];
	
	printf("Enter the numbers:\n");
	for(int i=0; i<n; i++)
	{
		scanf("%d",&array[i]);
	}
	for(x=0; x<n; x++)
	{
		int count=0;
		for(y=0; y<n; y++)
		{
			if(array[x]==array[y])
			count++;
		}
		if(count==2)
		{
			duplicate=array[x];
			printf("Duplicate Number: %d\n",duplicate);
			break;
		}
		
	}
	//One number is missing. Its value is not added at all
	//One number is duplicated.Its value is added one extra time
	//So compared to the correct sum:

	//1.Missing number removes its value
	//2.Duplicate number adds its value one extra time
	
	//Actual=Expected+Duplicate-Missing
	
	int actual_sum = 0;
    for(int i=0; i<n; i++)
    {
        actual_sum += array[i];
    }

    int expected_sum = n * (n + 1) / 2;

    int missing = expected_sum + duplicate - actual_sum;

    printf("Missing Number: %d\n", missing);

    return 0;
	
}
