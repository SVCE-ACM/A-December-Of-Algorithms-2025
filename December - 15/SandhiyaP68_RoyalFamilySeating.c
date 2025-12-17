#include <stdio.h>

int main() {
    int n;
    printf("enter number of nodes: ");
    scanf("%d", &n);

    int arr[1005];
    int i;

    printf("enter tree nodes (-1 for null): ");
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int null_seen = 0;

    for (i = 0; i < n; i++) {
        if (arr[i] == -1) {
            null_seen = 1;
        } else {
            if (null_seen == 1) {
                printf("false");
                return 0;
            }
        }
    }

    printf("true");
    return 0;
}
