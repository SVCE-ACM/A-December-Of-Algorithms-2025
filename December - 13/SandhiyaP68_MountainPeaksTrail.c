#include <stdio.h>

int main() {
    int n;
    printf("enter n: ");
    scanf("%d", &n);

    int arr[100000];
    int i;

    printf("enter the heights: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int found = 0;

    for (i = 1; i < n - 1; i++) {
        if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
            printf("%d ", i);
            found = 1;
        }
    }

    if (!found) {
        printf("-1");
    }

    return 0;
}
