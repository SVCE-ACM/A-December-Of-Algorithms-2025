#include <stdio.h>
#include <stdbool.h>

bool canReachLastStone(int stones[], int n) {
    int farthestReach = 0;

    for (int i = 0; i < n; i++) {
        if (i > farthestReach)
            return false;

        if (i + stones[i] > farthestReach)
            farthestReach = i + stones[i];
    }

    return true;
}

int main() {
    int n;
    printf("Enter the no of stones: ");
    scanf("%d", &n);

    int stones[n];


    printf("Enter the stones: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &stones[i]);
    }


    if (canReachLastStone(stones, n))
        printf("true");
    else
        printf("false");

    return 0;
}
