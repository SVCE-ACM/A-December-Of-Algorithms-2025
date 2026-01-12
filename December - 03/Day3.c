#include <stdio.h>
#include <stdbool.h>

bool canReachLastStone(int stones[], int n) {
    int maxReach = 0;

    for (int i = 0; i < n; i++) {
        if (i > maxReach)
            return false;

        if (i + stones[i] > maxReach)
            maxReach = i + stones[i];

        if (maxReach >= n - 1)
            return true;
    }

    return true;
}

int main() {
    int stones1[] = {2, 3, 1, 1, 4};
    int stones2[] = {3, 2, 1, 0, 4};

    int n1 = sizeof(stones1) / sizeof(stones1[0]);
    int n2 = sizeof(stones2) / sizeof(stones2[0]);

    printf("%s\n", canReachLastStone(stones1, n1) ? "true" : "false");
    printf("%s\n", canReachLastStone(stones2, n2) ? "true" : "false");

    return 0;
}
