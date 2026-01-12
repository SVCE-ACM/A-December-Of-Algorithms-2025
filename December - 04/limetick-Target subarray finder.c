#include <stdio.h>

int main() {
    int N, K;
    scanf("%d %d", &N, &K);

    int arr[N];
    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    int start = 0;
    int currentSum = 0;

    for (int end = 0; end < N; end++) {
        currentSum += arr[end];

        while (currentSum > K && start <= end) {
            currentSum -= arr[start];
            start++;
        }

        if (currentSum == K) {
            printf("%d %d", start, end);
            return 0;
        }
    }

    printf("-1 -1");
    return 0;
}
