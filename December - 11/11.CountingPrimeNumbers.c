#include <stdio.h>
#include <math.h>
int isPrime(int n) {
    if (n <= 1) return 0;  // 0 and 1 are not prime
    if (n == 2) return 1;  // 2 is prime
    if (n % 2 == 0) return 0; // even numbers > 2 are not prime
    for (int i = 3; i <= sqrt(n); i += 2) {
        if (n % i == 0)
            return 0;
    }
    return 1;
}
int main() {
    int N;
    printf("Enter N: ");
    scanf("%d", &N);
    int count = 0;
    for (int i = 2; i < N; i++) {
        if (isPrime(i)) {
            count++;
        }
    }
    printf("The count of prime numbers less than %d is: %d\n", N, count);
    return 0;
}
