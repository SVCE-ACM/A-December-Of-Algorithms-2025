#include <stdio.h>

int binaryLength(int n) {
    int length = 0;
    while (n > 0) {
        length++;
        n /= 2;
    }
    return length;
}

void printBinary(int n, int width) {
    int binary[32], index = 0;

    while (n > 0) {
        binary[index++] = n % 2;
        n /= 2;
    }

    for (int i = 0; i < width - index; i++)
        printf(" ");

    for (int i = index - 1; i >= 0; i--)
        printf("%d", binary[i]);
}

int main() {
    int N;
    scanf("%d", &N);

    int width = binaryLength(N);

    for (int i = 1; i <= N; i++) {
        printf("%*d ", width, i);
        printf("%*o ", width, i);
        printf("%*X ", width, i);
        printBinary(i, width);
        printf("\n");
    }

    return 0;
}
