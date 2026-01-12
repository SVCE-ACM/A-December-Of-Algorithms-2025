#include <stdio.h>
#include <stdlib.h>

int main() {
    int N;
    scanf("%d", &N);

    int *queue = (int *)malloc(N * sizeof(int));
    for (int i = 0; i < N; i++) {
        scanf("%d", &queue[i]);
    }

    int remaining = N;

    while (remaining > 0) {
        int minIndex = 0;
        for (int i = 1; i < remaining; i++) {
            if (queue[i] < queue[minIndex]) {
                minIndex = i;
            }
        }

        for (int i = 0; i < minIndex; i++) {
            int temp = queue[0];
            for (int j = 0; j < remaining - 1; j++) {
                queue[j] = queue[j + 1];
            }
            queue[remaining - 1] = temp;
        }

        printf("%d", queue[0]);
        if (remaining > 1) printf(" ");

        for (int i = 0; i < remaining - 1; i++) {
            queue[i] = queue[i + 1];
        }

        remaining--;
    }

    free(queue);
    return 0;
}
