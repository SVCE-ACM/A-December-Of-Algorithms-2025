#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    long long x = *(long long *)a;
    long long y = *(long long *)b;
    return (x > y) - (x < y);
}

int main() {
    int N;
    scanf("%d", &N);

    long long arr[N];
    for (int i = 0; i < N; i++) {
        scanf("%lld", &arr[i]);
    }

    qsort(arr, N, sizeof(long long), compare);

    long long sum = 0;

    for (int i = 0; i < N; i++) {
        int isUnique = 1;

        if (i > 0 && arr[i] == arr[i - 1])
            isUnique = 0;

        if (i < N - 1 && arr[i] == arr[i + 1])
            isUnique = 0;

        if (isUnique)
            sum += arr[i];
    }

    printf("%lld", sum);
    return 0;
}
