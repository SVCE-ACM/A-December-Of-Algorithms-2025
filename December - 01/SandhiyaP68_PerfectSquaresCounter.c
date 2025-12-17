#include<stdio.h>


int main() {
    int N;
    int count = 0;
    printf("Enter input:");
    scanf("%d", &N);

    for (int i = 1; i * i <= N; i++) {
        printf("%d ", i * i);
        count++;
    }

    printf("\n%d", count);

    return 0;
}

