#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    int arr[N];
    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    // Place each element at its correct index
    for (int i = 0; i < N; i++) {
        while (arr[i] != i + 1 && arr[i] != arr[arr[i] - 1]) {
            int temp = arr[i];
            arr[i] = arr[temp - 1];
            arr[temp - 1] = temp;
        }
    }

    int missing = -1, duplicate = -1;
    for (int i = 0; i < N; i++) {
        if (arr[i] != i + 1) {
            duplicate = arr[i];
            missing = i + 1;
            break;
        }
    }

    printf("Missing Number: %d\n", missing);
    printf("Duplicate Number: %d\n", duplicate);

    return 0;
}
