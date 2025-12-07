#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);
    int parcels[N];
    for ( int i = 0 ; i < N ; i++) {
        scanf("%d", &parcels[i]);
    }
    for ( int i = 0 ; i < N - 1 ; i++ ) {
        for ( int j = 0 ; j < N - i - 1 ; j++ ) {
            if ( parcels[j] > parcels[j+1] ) {
                int temp = parcels[j];
                parcels[j] = parcels[j+1];
                parcels[j+1] = temp;
            }
        }
    }
    for(int i = 0 ; i < N ; i++ ) {
        printf("%d ", parcels[i]);
    }
    return 0;
}