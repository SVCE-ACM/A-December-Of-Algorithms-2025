#include <stdio.h>

int main() {
    int N, count = 0;
    scanf("%d", &N);
    for ( int i = 1 ; i * i <= N ; i++ ) {
        printf("%d ", i * i);
        count++;
    }
    printf("\n%d", count);
    return 0;
}
