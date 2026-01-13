#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);
    int beads[N], necklace = 0;
    for (int i = 0; i < N; i++) {
        scanf("%d", &beads[i]);
    }   
    int i = 0;
    while ( N != 0) {
        int digit = beads[i];
        necklace = necklace * 10 + digit;
        N--;
        i++;
    }
    int reversedNecklace = 0, originalNecklace = necklace;
    while(necklace != 0) {
        int digit = necklace % 10;
        reversedNecklace = reversedNecklace * 10 + digit;
        necklace /= 10;
    }
    if( originalNecklace == reversedNecklace ) {
        printf("The necklace is mirrored.\n");
    } else {
        printf("The necklace is not mirrored.\n");
    }
}