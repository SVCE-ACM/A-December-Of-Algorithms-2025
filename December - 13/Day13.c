#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    int heights[N];
    for (int i = 0; i < N; i++)
        scanf("%d", &heights[i]);

    int found = 0;
    for (int i = 1; i < N - 1; i++) {
        if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
            if (found) printf(" ");
            printf("%d", i);
            found = 1;
        }
    }

    if (!found)
        printf("-1");

    return 0;
}
