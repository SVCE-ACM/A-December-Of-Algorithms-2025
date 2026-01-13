#include <stdio.h>

int main() {
    int N, count = 0;
    scanf("%d", &N);
    if ( N < 1 ) {
        printf("0\n");
        return 0;
    } else {
        for( int i  = 2 ; i <= N ; i++ ) {
            int divisors = 0;
            for( int j = 1 ; j <= i ; j++ ) {
                if ( i % j == 0 ) {
                    divisors++;
                }
            }
            if ( divisors == 2 ) {
                count++;
            }
        }
    }
    printf("The count of prime numbers less than %d is: %d\n", N, count);
    return 0;  
}