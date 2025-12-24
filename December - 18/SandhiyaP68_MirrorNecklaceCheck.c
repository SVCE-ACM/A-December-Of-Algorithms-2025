#include <stdio.h>

int main() {
    int n;
    printf("Enter number of beads: ");
    scanf("%d", &n);

    if (n == 0) {
        printf("The necklace is empty.");
        return 0;
    }

    int beads[100000];
    printf("Enter the beads: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &beads[i]);
    }

    int mirrored = 1;
    for (int i = 0; i < n / 2; i++) {
        if (beads[i] != beads[n - 1 - i]) {
            mirrored = 0;
            break;
        }
    }

    if (mirrored)
        printf("The necklace is mirrored.");
    else
        printf("The necklace is not mirrored.");

    return 0;
}
