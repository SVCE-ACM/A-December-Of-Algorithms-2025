#include <stdio.h>
#include <string.h>

int main() {
    int N;
    printf("Enter N: ");
    scanf("%d", &N);

    if(N <= 2) {
        printf("The count of prime numbers less than %d is: 0\n", N);
        return 0;
    }

    int isPrime[N];
    for(int i=0; i<N; i++) isPrime[i] = 1; // assume all are prime
    isPrime[0] = 0; // 0 is not prime
    isPrime[1] = 0; // 1 is not prime

    // Sieve of Eratosthenes
    for(int i=2; i*i<N; i++) {
        if(isPrime[i]) {
            for(int j=i*i; j<N; j+=i) {
                isPrime[j] = 0; // mark multiples as not prime
            }
        }
    }

    int count = 0;
    for(int i=2; i<N; i++) {
        if(isPrime[i]) count++;
    }

    printf("The count of prime numbers less than %d is: %d\n", N, count);
    return 0;
}
