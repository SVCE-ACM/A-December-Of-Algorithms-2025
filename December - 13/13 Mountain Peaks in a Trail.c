#include <stdio.h>

int main() {
    int N;
    printf("Enter number of checkpoints: ");
    scanf("%d", &N);

    int heights[N];
    printf("Enter elevations:\n");
    for(int i=0; i<N; i++) {
        scanf("%d", &heights[i]);
    }

    int hasPeak = 0; // flag to check if any peak exists

    for(int i=1; i<N-1; i++) {
        if(heights[i] > heights[i-1] && heights[i] > heights[i+1]) {
            printf("%d ", i);
            hasPeak = 1;
        }
    }

    if(!hasPeak) {
        printf("-1");
    }

    printf("\n");
    return 0;
}
