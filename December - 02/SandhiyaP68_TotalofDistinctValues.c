#include <stdio.h>

void printBinary(int n) {
    int bin[20];
    int i = 0;

    if (n == 0) {
        printf("0");
        return;
    }

    while (n > 0) {
        bin[i] = n % 2;
        n = n / 2;
        i++;
    }

    for (int j = i - 1; j >= 0; j--) {
        printf("%d", bin[j]);
    }
}

int binaryWidth(int n) {
    int count = 0;
    while (n > 0) {
        n = n / 2;
        count++;
    }
    return count;
}

int main() {
    int N;
    printf("Enter N:");
    scanf("%d", &N);

    int width = binaryWidth(N);

    for (int i = 1; i <= N; i++) {
        printf("%*d %*o %*X  ", width, i, width, i, width, i);
        printBinary(i);
        printf("\n");
    }

    return 0;
}
