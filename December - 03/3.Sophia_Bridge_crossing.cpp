#include <stdio.h>
//The function does NOT jump. It just records reachability
int ReachLast(int stones[], int n)
{
    int maxReach = 0;

    for (int i = 0; i < n; i++)
    {
        if (i > maxReach)
            return 0;

        if (i + stones[i] > maxReach)
            maxReach = i + stones[i];

        if (maxReach >= n - 1)
            return 1;
    }

    return 0;
}

int main()
{
    int n;
    printf("Enter number of stones: ");
    scanf("%d", &n);

    int stones[n];
    printf("Enter the stone values:\n");

    for (int i = 0; i < n; i++)
        scanf("%d", &stones[i]);

    if (ReachLast(stones, n))
        printf("True\n");
    else
        printf("False\n");

    return 0;
}

