#include <stdio.h>

int main() {
    int N, freq[10] = {0};
    scanf("%d", &N);
    int arr[N], sum = 0;
    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
        freq[arr[i]]++;
    }   
    for (int i = 0; i < 10; i++) {
        if (freq[i] == 1) {
            sum += i;
        }
    }
    printf("%d\n", sum);
}