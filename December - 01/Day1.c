#include <stdio.h>
#include <math.h>

int main() {
    int N;
    scanf("%d", &N);

    int limit = (int)sqrt(N);

    for(int i = 1; i <= limit; i++) {
        printf("%d ", i * i);
    }

    printf("\n%d", limit);
    return 0;
}
