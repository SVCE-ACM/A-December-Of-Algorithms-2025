#include <stdio.h>

int main() {
    int n, k;

    printf("Enter number of elements and target sum: ");
    scanf("%d %d", &n, &k);

    int arr[n];

    printf("Enter the elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int start = 0;
    int sum = 0;

    for (int end = 0; end < n; end++) {
        sum = sum + arr[end];

        while (sum > k) {
            sum = sum - arr[start];
            start++;
        }

        if (sum == k) {
            printf("%d %d", start, end);
            return 0;
        }
    }

    printf("-1 -1");
    return 0;
}
