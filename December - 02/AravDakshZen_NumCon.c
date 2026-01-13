#include <stdio.h>

int printBits(int x) {
    if ( x == 0 ) {
        return 0;
    }
    int bits[32], index = 0;
    while( x > 0 ) {
        bits[index++] = x % 2;
        x /= 2;
    }
    for( int i = index - 1 ; i >= 0 ; i-- ) {
        printf("%d", bits[i]);
    }
}

int main() {
    int N, binary[32];
    scanf("%d", &N);
    for( int i = 1 ; i <= N ; i++ ) {
        printf("%d %o %X ", i, i, i);
        printBits(i);
        printf("\n");
    }
    return 0;
}