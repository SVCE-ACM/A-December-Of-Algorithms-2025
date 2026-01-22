#include <stdio.h>

int main() {
    int n;

    printf("Enter the number of stones: ");
    scanf("%d", &n);

    int stones[n];

    printf("Enter the jump values for each stone:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &stones[i]);
    }

    int reach = 0;

    for (int i = 0; i < n; i++) {

        if (i > reach) {
            printf("false");
            return 0;
        }

        if (i + stones[i] > reach) {
            reach = i + stones[i];
        }
    }

    printf("true");
    return 0;
}
