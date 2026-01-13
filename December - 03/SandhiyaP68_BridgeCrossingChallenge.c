#include <stdio.h>

int main() {
    int n;
    int stones[10000];

    printf("Enter number of stones: ");
    scanf("%d", &n);

    printf("Enter stones array:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &stones[i]);
    }

    int maxReach = 0;
    int canReach = 1;   // assume true

    for (int i = 0; i < n; i++) {
        if (i > maxReach) {
            canReach = 0;
            break;
        }

        if (i + stones[i] > maxReach) {
            maxReach = i + stones[i];
        }
    }

    if (canReach == 1) {
        printf("true\n");
    } else {
        printf("false\n");
    }

    return 0;
}
