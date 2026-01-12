#include <stdio.h>
#include <stdlib.h>

int main() {
    int N;
    scanf("%d", &N);

    if (N <= 2) {
        printf("The count of prime numbers less than %d is: 0", N);
        return 0;
    }

    int *isPrime = (int *)malloc(N * sizeof(int));

    for (int i = 0; i < N; i++)
        isPrime[i] = 1;

    isPrime[0] = 0;
    isPrime[1] = 0;

    for (int i = 2; i * i < N; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j < N; j += i) {
                isPrime[j] = 0;
            }
        }
    }

    int count = 0;
    for (int i = 2; i < N; i++) {
        if (isPrime[i])
            count++;
    }

    printf("The count of prime numbers less than %d is: %d", N, count);

    free(isPrime);
    return 0;
}
