#include <stdio.h>
#include <stdlib.h>

int main() {
    int N;
    printf("Enter N: ");
    scanf("%d", &N);

    if (N <= 2) {
        printf("The count of prime numbers less than %d is: 0", N);
        return 0;
    }

    int *prime = (int*)malloc(N * sizeof(int));
    int i, j;

    for (i = 0; i < N; i++) {
        prime[i] = 1;
    }

    prime[0] = prime[1] = 0;

    for (i = 2; i * i < N; i++) {
        if (prime[i] == 1) {
            for (j = i * i; j < N; j += i) {
                prime[j] = 0;
            }
        }
    }

    int count = 0;
    for (i = 2; i < N; i++) {
        if (prime[i] == 1)
            count++;
    }

    printf("The count of prime numbers less than %d is: %d", N, count);

    free(prime);
    return 0;
}
