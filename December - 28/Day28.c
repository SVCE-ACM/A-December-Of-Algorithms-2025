#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    scanf("%d", &n);

    int *score = (int *)malloc(n * sizeof(int));
    int *sweet = (int *)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        scanf("%d", &score[i]);
        sweet[i] = 1;
    }

    for (int i = 1; i < n; i++) {
        if (score[i] > score[i - 1]) {
            sweet[i] = sweet[i - 1] + 1;
        }
    }

    for (int i = n - 2; i >= 0; i--) {
        if (score[i] > score[i + 1] && sweet[i] <= sweet[i + 1]) {
            sweet[i] = sweet[i + 1] + 1;
        }
    }

    int total = 0;
    for (int i = 0; i < n; i++) {
        total += sweet[i];
    }

    printf("%d", total);

    free(score);
    free(sweet);
    return 0;
}
