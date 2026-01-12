#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    if (N == 0) {
        printf("The necklace is empty.");
        return 0;
    }

    int beads[N];
    for (int i = 0; i < N; i++) {
        scanf("%d", &beads[i]);
    }

    int left = 0, right = N - 1;
    while (left < right) {
        if (beads[left] != beads[right]) {
            printf("The necklace is not mirrored.");
            return 0;
        }
        left++;
        right--;
    }

    printf("The necklace is mirrored.");
    return 0;
}
