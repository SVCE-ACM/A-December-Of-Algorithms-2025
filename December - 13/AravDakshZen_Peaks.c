#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);
    int heights[N], heightsCount = 0;
    for( int i = 0 ; i < N ; i++ ) {
        scanf("%d", &heights[i]);
    }
    for( int i = 1 ; i < N - 2 ; i++ ) {
        if ( heights[i] > heights[i+1] && heights[i] > heights[i-1]) {
            printf("%d ", i);
            heightsCount++;
        }
    }
    if ( heightsCount == 0 ) {
        printf("-1");
    }
    return 0;
}