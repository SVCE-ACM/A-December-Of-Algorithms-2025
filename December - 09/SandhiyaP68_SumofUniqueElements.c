#include <stdio.h>

int main() {
    int n;
    printf("Enter size of array: ");
    scanf("%d", &n);

    long long arr[100000];
    long long freq[100000];
    int i, j;

    printf("Enter the elements:\n");
    for (i = 0; i < n; i++) {
        scanf("%lld", &arr[i]);
        freq[i] = 1;
    }

    // Mark duplicates
    for (i = 0; i < n; i++) {
        if (freq[i] == 0) continue;
        for (j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                freq[i]++;
                freq[j] = 0;
            }
        }
    }

    long long sum = 0;
    for (i = 0; i < n; i++) {
        if (freq[i] == 1) {
            sum += arr[i];
        }
    }

    printf("Sum of unique elements: %lld", sum);

    return 0;
}
