#include <stdio.h>
#include <stdlib.h>

int main() {
    int N;
    scanf("%d", &N);

    long long *heights = (long long *)malloc(N * sizeof(long long));
    long long *result = (long long *)malloc(N * sizeof(long long));
    int *stack = (int *)malloc(N * sizeof(int));
    int top = -1;

    for (int i = 0; i < N; i++) {
        scanf("%lld", &heights[i]);
        result[i] = -1;
    }

    for (int i = 0; i < N; i++) {
        while (top >= 0 && heights[i] > heights[stack[top]]) {
            result[stack[top]] = heights[i];
            top--;
        }
        stack[++top] = i;
    }

    for (int i = 0; i < N; i++) {
        printf("%lld", result[i]);
        if (i < N - 1) printf(" ");
    }

    free(heights);
    free(result);
    free(stack);
    return 0;
}
