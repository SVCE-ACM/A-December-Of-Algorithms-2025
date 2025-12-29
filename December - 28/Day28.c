
#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int score[20000], candy[20000];
    for (int i = 0; i < n; i++) {
        scanf("%d", &score[i]);
        candy[i] = 1;
    }

    for (int i = 1; i < n; i++) {
        if (score[i] > score[i - 1])
            candy[i] = candy[i - 1] + 1;
    }

    for (int i = n - 2; i >= 0; i--) {
        if (score[i] > score[i + 1] && candy[i] <= candy[i + 1])
            candy[i] = candy[i + 1] + 1;
    }

    int sum = 0;
    for (int i = 0; i < n; i++)
        sum += candy[i];

    printf("%d\n", sum);
    return 0;
}
