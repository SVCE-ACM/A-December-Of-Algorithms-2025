#include <stdio.h>
#include <math.h>   

int main() {
    int N;
    scanf("%d", &N);
    int skills[N], min = 9999;
    for ( int i = 0 ; i < N ; i++ ) {
        scanf("%d", &skills[i]);
    }
    for( int i = 0 ; i < N ; i++ ) {
        for( int j = i + 1 ; j < N ; j++ ) {
            if ( abs(skills[i] - skills[j]) < min ) {
                min = abs(skills[i] - skills[j]);
            }
        }
    }
    printf("%d\n", min);
}