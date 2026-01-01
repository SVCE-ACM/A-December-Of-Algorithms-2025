#include <stdio.h>

int main() {
    int N;
    printf("Enter number of beads: ");
    scanf("%d", &N);

    if(N == 0) {
        printf("The necklace is empty.\n");
        return 0;
    }

    int beads[N];
    printf("Enter bead numbers:\n");
    for(int i = 0; i < N; i++) {
        scanf("%d", &beads[i]);
    }

    int mirrored = 1; // assume mirrored
    for(int i = 0; i < N/2; i++) {
        if(beads[i] != beads[N-1-i]) {
            mirrored = 0;
            break;
        }
    }

    if(mirrored) {
        printf("The necklace is mirrored.\n");
    } else {
        printf("The necklace is not mirrored.\n");
    }

    return 0;
}
