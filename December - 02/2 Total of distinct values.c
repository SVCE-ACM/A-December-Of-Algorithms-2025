#include <stdio.h>

// Function to print binary number
void printBinary(int n) {
    int bin[20];
    int i = 0;

    // Convert to binary
    while (n > 0) {
        bin[i] = n % 2;
        n = n / 2;
        i++;
    }

    // Print binary in reverse
    for (int j = i - 1; j >= 0; j--) {
        printf("%d", bin[j]);
    }
}

int main() {
    int N;
    scanf("%d", &N);

    for (int i = 1; i <= N; i++) {
        // Decimal
        printf("%d ", i);

        // Octal
        printf("%o ", i);

        // Hexadecimal (UPPERCASE)
        printf("%X ", i);

        // Binary
        printBinary(i);

        printf("\n");
    }

    return 0;
}
